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
    </head>
    <body>
    <div class="container">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="home">Home</a>
    </li>
    
  </ul>
</nav>
<br/>
<center>
        @foreach($friends as $frnd)

        <h1>{{$frnd->name}}</h1>
        <h5>{{$frnd->id}}</h5>
        <a href="{{url('unfriend')}}/{{$frnd->id}}" class="btn btn-danger">Unfriend</a>
        @endforeach
        
         </center>
         </div>
    </body>
</html>