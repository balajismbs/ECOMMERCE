<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class friendship extends Model
{
    protected $fillable=['user_id','friend','status'];
}
