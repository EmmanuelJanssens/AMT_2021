<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Role extends Model
{
    use HasFactory;

    public $timestamps = false;

    protected $keyType = "string";

    protected $fillable = [
        'id'
    ];

    public function users() {
        return $this->hasMany(User::class);
    }
}
