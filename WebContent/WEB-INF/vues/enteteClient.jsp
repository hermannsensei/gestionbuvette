<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buvette en ligne </title>
<link type="text/css" rel="stylesheet" href="style/style2.css" />
<link rel="stylesheet" type="text/css" href="style/bootstrap.min.css"> 


</head>
<body>
<script src="style/util.js"> </script>
<script src="style/bootstrap.js"> </script>
<div>
<p>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="interfaceClientServlet?action=infosclient"> ${ sessionScope.client.nom}  ${ sessionScope.client.prenom} </a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
  </li>
       <li class="nav-item active">
        <a class="nav-link" href="interfaceClientServlet"> ACCEUIL </a>
      </li> 
       <li class="nav-item active">
        <a class="nav-link" href="interfaceClientServlet">  </a>
      </li> 
       <li class="nav-item active">
        <a class="nav-link" href="interfaceClientServlet?action=toutecommande"> Toutes vos commandes ici </a>
      </li>      
      <li class="nav-item active" >
         <a class="nav-link" href="authentificationServlet?etat=deconnexion">
          DECONNEXION
        </a>
      </ul>
</div>
<form class="form-inline" method ="post" action ="interfaceClientServlet">
    <input class="form-control mr-sm-2" type="search" placeholder="Rechercher " aria-label="Search" name ="search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
  </form>
  </div>
</nav>