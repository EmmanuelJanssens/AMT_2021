<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use Illuminate\Support\Facades\Auth;
use App\Models\User;
use Validator;
use App\Http\Resources\AccountResource;

class AuthController extends Controller
{
  /**
   * Get a JWT via given credentials.
   *
   * @return \Illuminate\Http\JsonResponse
   */
  public function login(Request $request){
    $validator = Validator::make($request->all(), [
          'username' => 'required',
          'password' => 'required|string',
      ]);

      if ($validator->fails()) {
          return response()->json($validator->errors(), 422);
      }

      if (! $token = auth()->attempt($validator->validated())) {
          return response()->json(['error' => 'Invalid credentials'], 401);
      }

      return $this->createNewToken($token);
  }

  /**
     * Register a User.
     *
     * @return \Illuminate\Http\JsonResponse
     */
    public function register(Request $request) {
      $validator = Validator::make($request->all(), [
          'username' => 'required|string|between:2,100|unique:users',
          'password' => 'required|string|confirmed|min:6',
      ]);

      if($validator->fails()){
          return response()->json($validator->errors()->toJson(), 400);
      }

      $user = User::create([
          'username' => $request->username,
          'password' => bcrypt($request->password),
          'role_id' => 'user'
      ]);

      return response()->json(new AccountResource($user), 201);
  }


  /**
   * Log the user out (Invalidate the token).
   *
   * @return \Illuminate\Http\JsonResponse
   */
  public function logout() {
      auth()->logout();

      return response()->json(['message' => 'User successfully signed out']);
  }

  /**
     * Refresh a token.
     *
     * @return \Illuminate\Http\JsonResponse
     */
    public function refresh() {
      return $this->createNewToken(auth()->refresh());
  }

  /**
   * Get the authenticated User.
   *
   * @return \Illuminate\Http\JsonResponse
   */
  public function userProfile() {
      return new AccountResource(auth()->user());
  }

  /**
   * Get the token array structure.
   *
   * @param  string $token
   *
   * @return \Illuminate\Http\JsonResponse
   */
  protected function createNewToken($token){
      $user = auth()->user();
      return response()->json([
          'token' => $token,
          'token_type' => 'bearer',
          'expires_in' => auth()->factory()->getTTL() * 60,
          'account' => new AccountResource($user)
      ]);
  }
}
