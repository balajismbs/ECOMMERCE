<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\task;
use Illuminate\Support\Facades\Auth;

class taskcontroller extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
   
    public function index()
    {
        
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $user=Auth::user();
        return view('main',compact('user'));
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate($request,[
            'task'=>'required',
            'date'=>'required|date',
        ]);
        $names=new task([
            'name'=>$request->get('name'),
            'task'=>$request->get('task'),
            'date'=>$request->get('date'),
        ]);
        $names->save();
        return redirect('home');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id,Request $request)
    {
        $user=Auth::user();
        $hello=task::find($id);
        return view('edit',compact('hello','id','user'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $this->validate($request,[
            'task'=>'required',
            'date'=>'required',
        ]);
        $hello=task::find($id);
        $hello->task=$request->get('task');
        $hello->date=$request->get('date');
        $hello->save();
        return redirect('home');

    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $hello=task::find($id);
        $hello->delete($id);
        return redirect('home');
    }
}
