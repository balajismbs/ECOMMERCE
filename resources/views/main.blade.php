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
</head>
<body>
<div id="app">
    <div class="container">
        <h1>hello {{$user->name}}</h1>
        <div class="align">
                    @if(count($errors)>0)
                    <div class="alert alert-danger">
                    @foreach($errors->all() as $error)
                    <li>{{$error}}</li>
                    @endforeach
                    </div>
                    @endif
        <div class="align">
            <form action="{{url('test')}}" method="post">
            {{csrf_field()}}
            <div class="form-group">
            <input type="hidden" value="{{Auth::user()->name}}" name="name" class="form-control">           
            </div>
            <div class="form-group">
            <b>TASK:</b>
            <input type="text" name="task" class="form-control">
            </div>
            <div class="form-group">
            <b>DATE:</b>
            <input type="text" name="date" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">+ add</button>
            </form>
        </div>
    </div>
</div>    
</body>
</html>