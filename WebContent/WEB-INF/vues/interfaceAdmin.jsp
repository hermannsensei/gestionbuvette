<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta http-equiv="refresh" content="60">
 <link type="text/css" rel="stylesheet" href="style/style2.css" />
<link rel="stylesheet" type="text/css" href="style/bootstrap.min.css"> 
<title>Buvette en ligne</title>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="modificationUtilisateurServlet"> ${ sessionScope.admin.nom } ${ sessionScope.admin.prenom }</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <!-- <li class="nav-item active">
        <a class="nav-link" href="#"> ENSAJ <span class="sr-only">(current)</span></a>
      </li> -->
         <li class="nav-item">
        <a class="nav-link" href="interfaceAdminServlet">ACCEUIL</a>
      </li>
   
         <li class="nav-item">
        <a class="nav-link" href="creationMenuServlet">AJOUTER MENU</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="modificationMenuServlet"> MODIFIER MENU</a>
      </li> 
      <li class="nav-item">
        <a class="nav-link" href="creationUtilisateurServlet">AJOUTER CLIENT</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="stat">ESPACE STATISTIQUES</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="authentificationServlet?action=deconnexion">DECONNEXION</a>
      </li>
    <a class="nav-link" href="toutecommande"><button type="button" class="btn btn-primary">
  Commandes <span class="badge badge-light"> ${ sessionScope.notificationCommande}</span>
</button> <span class="sr-only">(current)</span></a>
      </li>
      </ul>
  </div>
 <form class="form-inline" method ="post" action ="interfaceAdminServlet">
    <input class="form-control mr-sm-2" type="search" placeholder="Rechercher " aria-label="Search" name ="search">
    <button class="btn btn-primary" type="submit">Rechercher</button>
  </form>
</nav>

<center> <h2> <strong> HISTORIQUES DES COMMANDES </strong></h2></center>
<div class = "container"> 
  <table class="table table-bordered table-dark">
  <thead>
    <tr>
      <th scope="col">Date</th>
      <th scope="col">Heure</th>
      <th scope="col">Menu</th>
      <th scope="col">Prix du menu</th>
      <th scope="col">Client</th>
    </tr>
  </thead>
  <tbody>
   
      <c:forEach items ="${sessionScope.listCommandes}" var="elementCommande"> 
       <tr>
  <td> <c:out value= "${elementCommande.dateCommande}" /> </td>
  <td> <c:out value= "${elementCommande.heureCommande}" /> </td>
  <td> <c:out value= "${elementCommande.nomMenu}" /> </td>
  <td> <c:out value = "${elementCommande.prixMenu} dhs" /> </td>
  <td> <c:out value = "${elementCommande.pseudo} " /> </td>
    </tr> 
      </c:forEach>
  
  </tbody>
 </table>



</div>


</body>

</html>