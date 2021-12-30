<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
        \App\Models\Role::create([
           'id' => 'user'
        ]);
        \App\Models\Role::create([
           'id' => 'admin'
        ]);
        // \App\Models\User::factory(10)->create();
        \App\Models\User::create([
          'username' => 'fabio',
          'role_id' => 'admin',
          'password' => bcrypt('1234')
        ]);
    }
}
