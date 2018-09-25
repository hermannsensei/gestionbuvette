<%@ include file="enteteAdmin.jsp" %>

<center> <h2> <strong> HISTORIQUES DES COMMANDES </strong></h2></center>

</br> 
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
   
      <c:forEach items ="${sessionScope.listTCommandes}" var="elementCommande"> 
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