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

<center > <h2> <strong> QUELQUES CHIFFRES .... </strong></h2></center>

</br> 
</br> 
<div class = "container" > 
<table class="table table-bordered table-light">
  <thead class="table-dark">
    <tr>
      <th scope="col">Nbre de commande</th>
      <th scope="col">Nombre de Menus</th>
      <th scope="col">Nombres de clients</th>
    </tr>
  </thead>
  <tbody>
       <tr>
  <td> <c:out value= "${sessionScope.nbreCommande}" /> </td>
  <td> <c:out value= "${sessionScope.nbreMenu}" /> </td>
  <td> <c:out value= "${sessionScope.nbreClient} " /> </td>
    </tr> 
  
  </tbody>
 </table>
</div>S
<center> 
<div class="container-fluid"> 
<form method = "get" action = "interfaceAdminServlet" align = "center" >
 </select> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
<input type="submit" value="OK" size="" class="btn btn-primary"/>
</form>
</div>

</center>




</body>
</html>