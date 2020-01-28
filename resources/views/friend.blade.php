<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSRF Token -->
    <meta name="csrf-token" content="{{ csrf_token() }}">

    <title>{{ config('app.name', 'Laravel') }}</title>

    <!-- Scripts -->
    <script src="{{ asset('js/app.js') }}" defer></script>

    <!-- Fonts -->
    <link rel="dns-prefetch" href="//fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet">

    <!-- Styles -->
    <link href="{{ asset('css/app.css') }}" rel="stylesheet">
    <link href="{{ asset('css/sample.css') }}" rel="stylesheet">
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div id="text">
        <div class="container">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="home">Home</a>
    </li>
    
  </ul>
</nav>
        <br/>
            <div class="shadow p-3 mb-3 bg-white rounded">
                <center><h1>hello</h1>
                @if(\Session::has('msg'))
                <p>{{\Session::get('msg')}}</p>
                @endif
            @foreach($friendship as $frnd)
            <li>{{$frnd->name}}</li>
            
             <span><a href="{{url('accept')}}/{{$frnd->id}}" class="btn btn-success">confirm</a></span>
             <span><a href="{{url('remove')}}/{{$frnd->id}}" class="btn btn-success">remove</a></span>
             
             @endforeach
            </center>

            </div>
        </div>
        </div>
    </body>
</html>