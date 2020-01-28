<?php

namespace App\Traits;
use App\friendship;
trait Friendable
{
    public function addfriend($name){
        $friend=friendship::create([
            'user_id'=>$this->id,
            'friend'=>$name,
        ]);
        // if($friend)
        // {
        //     return $friend;
        // }
        // else
        // {
        //     return 'failed';
        // }
    }
}