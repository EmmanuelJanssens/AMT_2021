<?php

namespace Tests\Feature;

use App\Models\User;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Testing\Fluent\AssertableJson;
use Tests\TestCase;

class AuthTest extends TestCase
{
    protected $authUserToken;
    protected $authUser;
    protected $authUserPassword;

    public function setUp(): void
    {
        parent::setUp();

        // setup default authenticated user
        $this->authUserPassword = "12345678";
        $this->authUser = User::factory()->state([
            'password' => bcrypt($this->authUserPassword)
        ])->create();
        $response = $this->loginUser($this->authUser->username, $this->authUserPassword);
        $this->authUserToken = $response->json("token");
    }

    private function loginUser($username, $password) {
        $response = $this->postJson('/auth/login', [
            'username' => $username,
            'password' => $password,
            'password_confirmation' => $password
        ]);

        return $response;
    }

    public function test_login_user_ok() {
        $user = User::factory()->state([
            'password' => bcrypt($this->authUserPassword)
        ])->create();
        $response = $this->loginUser($user->username, $this->authUserPassword);

        $response->assertStatus(200)
            ->assertJson(function (AssertableJson $json) {
                return $json
                    ->whereType('token', 'string')
                    ->where('token_type', 'bearer')
                    ->whereType('expires_in', 'integer')
                    ->has('account');
            });
        $user->delete();
    }

    public function test_login_wrong_credentials() {
        $response = $this->loginUser("unknown", $this->authUserPassword);

        $response->assertStatus(401);
    }

    public function test_login_incorrect_params() {
        $response = $this->loginUser("", "");

        $response->assertStatus(422)
            ->assertJson(function (AssertableJson $json) {
                return $json
                    ->has("username")
                    ->has("password");
            });
    }

    public function test_register_ok() {
        $response = $this
            ->postJson('/auth/register', [
                'username' => 'new_user_test_register',
                'password' => '12345678',
                'password_confirmation' => '12345678'
            ]);
        $response->assertStatus(201);

        $user = User::find($response->json('id'));
        $user->delete();
    }

    public function test_register_missing_params() {
        $response = $this->postJson('/auth/register');

        $response->assertStatus(400)
            ->assertJson(function (AssertableJson $json) {
                return $json
                    ->has('username')
                    ->has('password');
            });
    }

    public function test_register_wrong_password_format() {
        $response = $this->postJson('/auth/register', [
            'username' => 'new_user_test_wrong_password',
            'password' => '123'
        ]);

        $response->assertStatus(400)
            ->assertJson(function (AssertableJson $json) {
                return $json
                    ->has('password');
            });
    }

    public function test_register_already_exists() {
        $response = $this->postJson('/auth/register', [
            'username' => $this->authUser->username,
            'password' => $this->authUserPassword
        ]);

        $response->assertStatus(400)
            ->assertJson(function (AssertableJson $json) {
                return $json->where('username.0', 'The username has already been taken.')
                    ->etc();
            });
    }

    public function test_authenticated_user_info() {
        $user = $this->authUser;
        $response = $this
            ->withHeaders([
                'Authorization' => "Bearer $this->authUserToken"
            ])
            ->getJson('/auth/user-profile');

        $response
            ->assertStatus(200)
            ->assertJson(function (AssertableJson $json) use ($user) {
                return $json
                    ->whereType('id', 'integer')
                    ->where('username', $user->username)
                    ->where('role', $user->role_id);
            });
    }

    public function test_rejected_unauthenticated_user() {
        auth()->logout();
        $response = $this->getJson('/auth/user-profile');

        $response->assertStatus(401);
    }

    public function test_logout_user() {
        $user = User::factory()->state([
            'password' => bcrypt($this->authUserPassword)
        ])->create();
        $response = $this->loginUser($user, $this->authUserPassword);
        $token = $response->json('token');
        $response = $this
            ->withHeaders([
                'Authorization' => "Bearer $token"
            ])
            ->postJson('/auth/logout');

        $response->assertStatus(200);
        $user->delete();
    }

    public function test_rejected_logout_if_unauthenticated() {
        auth()->logout();
        $response = $this->postJson('/auth/logout');
        $response->assertStatus(401);
    }

    public function test_refresh_token_ok() {
        $response = $this
            ->withHeaders([
                'Authorization' => "Bearer $this->authUserToken"
            ])
            ->postJson('/auth/refresh');

        $response->assertStatus(200);
    }

    public function test_rejected_refresh_if_unauthenticated() {
        auth()->logout();
        $response = $this->postJson('/auth/refresh');
        $response->assertStatus(401);
    }

    protected function tearDown(): void
    {
        parent::tearDown();
        $this->authUser->delete();
    }
}
