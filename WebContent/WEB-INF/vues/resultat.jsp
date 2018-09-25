<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> --%>
<%@ include file="enteteClient.jsp" %>
</br> <br />

  <center> <strong> <h2> <font color="red" > ${affiche } </font> </h2></strong></center>
<div class = "container"> 
  <table class="table table-bordered table-light">
  <thead class="table-dark">
    <tr>
      <th scope="col">Date de la commande</th>
      <th scope="col">Heure de la commande </th>
      <th scope="col">Menu</th>
      <th scope="col">Prix du menu</th>
       <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
   
      <c:forEach items ="${rechercheCommande}" var="elementCommande"> 
       <tr>
  <td> <c:out value= "${elementCommande.dateCommande}" /> </td>
 <td> <c:out value= "${elementCommande.heureCommande}" /> </td>
 <td><em>  <c:out value = "${elementCommande.nomMenu} " /> </em>  </td>
  <td> <c:out value = "${elementCommande.prixMenu} dhs" /> </td>
  <td> <a href="interfaceClientServlet?supprimer=supprimer&idCommande=<c:out value= "${elementCommande.idCommande}" />">Supprimer</a> </td>
  
    </tr> 
      </c:forEach>
  
  </tbody>
 </table>
</div>
<div class="container-fluid"> 
     
    <h2>  ${ message} </h2>  

 </div>
 </br> <br />
 
<center> 

<div class="container-fluid"> 
<form method = "get" action = "interfaceClientServlet" align = "center" >
 </select> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
<input type="submit" value="OK" size="" class="btn btn-primary"/>
</form>
</div> 

</center>




</body>
</html>