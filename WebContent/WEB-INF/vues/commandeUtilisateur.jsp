<%@include file ="enteteClient.jsp" %>
<div class = "container"> 
  <table class="table table-bordered table-light">
  <thead class="table-dark">
    <tr>
      <th scope="col">Date</th>
      <th scope="col">Heure</th>
      <th scope="col">Menu</th>
      <th scope="col">Prix du menu</th>
    </tr>
  </thead>
  <tbody>
   
      <c:forEach items ="${sessionScope.toutesCommande}" var="elementCommande"> 
       <tr>
  <td> <c:out value= "${elementCommande.dateCommande}" /> </td>
  <td> <c:out value= "${elementCommande.heureCommande}" /> </td>
  <td> <c:out value= "${elementCommande.nomMenu}" /> </td>
  <td> <c:out value = "${elementCommande.prixMenu} dhs" /> </td>
    </tr> 
      </c:forEach>
  
  </tbody>
 </table>
</div>

</body>
</html>