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
    <link href="{{ asset('css/sample1.css') }}" rel="stylesheet">
</head>
<body>
    <h1>hello {{$user->name}}</h1>
    <div class="container">
        <form action="{{action('taskcontroller@update',$id)}}" method="post">
        {{csrf_field()}}
        <input type="hidden" name="_method" value="PATCH"/>
        <div class="form-group">
        <input type="text" value="{{$hello->task}}" name="task" class="form-control">
        </div>
        <div class="form-group">
        <input type="text" value="{{$hello->date}}" name="date" class="form-control">
        </div>
        <input type="submit" value="update" class="btn info">
        </form>
    </div>
</body>
</html>