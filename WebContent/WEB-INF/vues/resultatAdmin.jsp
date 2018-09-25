<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> --%>
<%@ include file="enteteAdmin.jsp" %>
 


 <%-- <c:if test="${!empty rechercheMenu.size}"}> --%>
 <div class = "container"> 
  <h2> Les menus associés à ${recherche}</h2>
  <table class="table table-bordered table-light">
  <thead class="table-dark">
    <tr>
      <th scope="col">Date</th>
      <th scope="col">Menu</th>
      <th scope="col">Prix du menu</th>
    </tr>
  </thead>
  <tbody>
 
      <c:forEach items ="${rechercheMenu}" var="elementMenu"> 
       <tr>
  <td> <c:out value= "${elementMenu.dateDajout}" /> </td>
  <td> <c:out value= "${elementMenu.nom}" /> </td>
  <td> <c:out value= "${elementMenu.prix} dhs" /> </td>
    </tr> 
      </c:forEach>
  
  </tbody>
 </table>
 </div> 
<%--  </c:if> --%>


</br> 
</br>
<%-- <<c:if test="${!empty rechercheCommande }"> --%>
<div class = "container"> 
<h2> Les commandes associés à ${recherche}</h2>
  <table class="table table-bordered table-light">
  <thead class="table-dark">
    <tr>
      <th scope="col">Date</th>
      <th scope="col">Heure commande </th>
    </tr>
  </thead>
  <tbody>
   
      <c:forEach items ="${rechercheCommande}" var="elementMenu"> 
       <tr>
  <td> <c:out value= "${elementMenu.dateCommande}" /> </td>
  <td> <c:out value= "${elementMenu.heureCommande}" /> </td>
 
    </tr> 
      </c:forEach>
  
  </tbody>
 </table>
</div>
<%-- </c:if>
 --%>
</br> 

<%-- <<c:if test="${!empty rechercheClient }"> --%>


<div class = "container"> 
<h2> Les clients associés à ${recherche}</h2>
  <table class="table table-bordered table-light">
  <thead class="table-dark">
    <tr>
      <th scope="col">Nom du client</th>
      <th scope="col">Son prénom </th>
      <th scope="col">Son pseudo</th>
      <th scope="col">Inscription</th>
    </tr>
  </thead>
  <tbody>
   
      <c:forEach items ="${rechercheClient}" var="elementMenu"> 
       <tr>
  <td> <c:out value= "${elementMenu.nom}" /> </td>
  <td> <c:out value= "${elementMenu.prenom}" /> </td>
  <td> <c:out value= "${elementMenu.pseudo} " /> </td>
  <td> <c:out value= "${elementMenu.dateEnregistrement} " /> </td>
    </tr> 
      </c:forEach>
  
  </tbody>
 </table>
</div>
</br>




<%-- </c:if> --%>

<div class="container-fluid"> 
     
    <h2>  ${ message} </h2>  

 </div>

<center> 
<form method = "get" action = "interfaceAdminServlet"  >
  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
<input type="submit" value="OK" size="" class="btn btn-primary"/>
</form>

</center>








</body>
</html>