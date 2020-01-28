<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use DB;
use App\task;
use App\User;
use App\friendship;
use Auth;
use Session;

class HomeController extends Controller
{
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('auth');
    }

    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Contracts\Support\Renderable
     */
    public function index(Request $request)
    {
        $uid=Auth::user()->name;
        $request->session()->put('name', $uid);
        $name=Auth::user();
        $uid=Auth::user()->id;
        $friend=DB::table('users')->where('id','!=',$uid)->get();
        $check=DB::table('users')->where(['name'=>Auth::user()->name])->get();
        Session::put('$check');
        $names=task::where('name','=', $request->session()->get('name'))->get();
        return view('home',compact('names','check','friend','name'));
    }
    public function addfriend($name){
        Auth::user()->addfriend($name);

       return back();
    }
    public function request(){

        $uid=Auth::user()->name;

        $friendship=DB::table('friendships')
                ->rightJoin('users','users.id','=','friendships.user_id')
                ->where('status',null)
                ->where('friendships.friend','=',$uid)->get();
        return view('friend',compact('friendship'));
    }
    public function accept($id){
        $uid=Auth::user()->name;
        $check=friendship::where('user_id',$id)
                ->where('friend',$uid)
                ->first();
        if($check){
          $update=DB::table('friendships')
                ->where('friend',$uid)
                ->where('user_id',$id)
                ->update(['status'=>1]);
                if($update){
                    return back()->with('msg','you friend with this user');
                }
        }

        else{
            return back()->with('msg','you friend with this user');
        }
    }
    public function friend(){
         $uid=Auth::user()->id;
         $uname=Auth::user()->name;
         $friend1=DB::table('friendships')
                ->leftJoin('users','users.name','friendships.friend')
                ->where('status',1)
                ->where('user_id',$uid)
                ->get();
        //    dd($friend1);    
        $friend2=DB::table('friendships')
        ->leftJoin('users','users.id','friendships.user_id')
                ->where('status',1)
                ->where('friend',$uname)
                ->get();

                // dd($friend2);
         $friends=array_merge($friend1->toArray(),$friend2->toArray());

         return view('list',compact('friends'))  ;  

    }
    public function remove($id){
        DB::table('friendships')
        ->where('friend',Auth::user()->name)
        ->where('user_id',$id)
        ->delete();
        return back();
    }
    public function unfriend($id){
        DB::table('friendships')
        ->where('user_id',$id)
        ->where('friend',Auth::user()->name)
        ->update(['status'=>null]);
        return back();
        // echo $id;
    }
}
