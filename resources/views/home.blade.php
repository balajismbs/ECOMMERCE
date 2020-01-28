@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-left">
        <div class="col-md-8">
            <div id="text">
            <div class="card shadow">
                <div class="card-header" style="text-align:center"><b>Task to be complete</b></div>

                <div class="card-body">
                    @if (session('status'))
                        <div class="alert alert-success" role="alert">
                            {{ session('status') }}
                        </div>
                    @endif

                    <table class="table table-striped">
                            <thead>
                                <tr>
                                 <th>Task</th>
                                 <th>Date</th>
                                 <th>Edit</th>
                                 <th>Delete</th>
                                </tr>
                            </thead>
                        <tbody>
                             @foreach($names as $value)
                                <tr>
                                    <td>{{$value->task}}</td>
                                    <td>{{$value->date}}</td>
                                    <td>
                                    <a href="{{action('taskcontroller@edit',$value['id'])}}"><button type="submit" class="btn info">edit</button></a>
                                    </td>
                                    <td>
                                    <form action="{{action('taskcontroller@destroy',$value['id'])}}" method="post">
                                    {{csrf_field()}}
                                    <input type="hidden" name="_method" value="DELETE">
                                    <button type="submit" class="btn danger">delete</button>
                                    </form>
                                    </td>
                                </tr>
                             @endforeach
                        </tbody>
                    </table>
                </div>
            </div>
            </div>
        </div>
        <div class="col-md-4">
            <div id="text">
            <div class="card shadow">
                <div class="card-header" style="text-align:center"><b>Suggested friends</b></div>
                <div class="card-body">
                @foreach($friend as $frnd)
                <div class="shadow p-3 mb-3 bg-white rounded">
                   <center> <h5>{{$frnd->name}}</h5>
                   <?php
                   $check=DB::table('friendships')
                            ->where('user_id','=',Auth::user()->id)
                            ->where('friend','=',$frnd->name)
                            ->first();
                    if($check == ''){
                   ?>
                   <a href="{{url('/')}}/friend/{{$frnd->name}}" class="btn info">add friend</a>
                    <?php } else {?>
                        <b>friend request sent......</b>
                    <?php }?>
                   </center>
                </div>
                @endforeach
                </div>
            </div>
            </div>
        </div>
    </div>
</div>
@endsection
