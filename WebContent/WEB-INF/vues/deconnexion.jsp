<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Buvette en ligne</title>

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/signin.css" rel="stylesheet">
  </head>

  <body>
      	<script src="style/util.js"> </script>
  	<script src="style/bootstrap.js"> </script>
    <div class="container">
      <form class="form-signin" method="post" action = "authentificationServlet">
        <h2 class="form-signin-heading"> ${connexion} </h2>
        <label for="inputText" class="sr-only">Login</label>
        <input type="text" id="inputText" class="form-control" placeholder="Login " required autofocus name = "login">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name ="mdp">
      <!--   <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
 -->        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>
