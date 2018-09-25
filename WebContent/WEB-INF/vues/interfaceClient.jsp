<%@ include file="enteteClient.jsp" %>
<br />
<div class="container">
 
  <center> <strong> <h2> <font color="red" > Vos derniers achats ! </font> </h2></strong></center>
   </div>
  </div>
<div class="container-fluid">
<div class= "container">
<div class="row">
<form method = "post" action = "interfaceClientServlet" >
 <label for="menu"> <h3> Que voulez vous manger ? </h3></label><br />
 <select name="menu" id="menu" class = > 
 <c:forEach items = "${sessionScope.listMenu}" var = "elementMenu" >
 <option  value="<c:out value= "${elementMenu.nom}" />" > ${elementMenu.nom} :  ${elementMenu.prix} DHS </option>
 </c:forEach>
 </select> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
<input type="submit" value="COMMANDER" size="" class="btn btn-primary"/>
</form>
 </div> 
</div>
</div>
<br />
<br />

<div class = "container"> 
  <table class="table table-bordered table-light">
  <thead class="table-dark">
    <tr>
      <th scope="col">Date de la commande </th>
      <th scope="col">Heure de la commande</th>
      <th scope="col">Menu </th>
      <th scope="col">Prix du menu</th>
      
    </tr>
  </thead>
  <tbody>
   
      <c:forEach items ="${sessionScope.listCommandes}" var="elementCommande"> 
       <tr>
        
  <td>  <c:out value= "${elementCommande.dateCommande}" />   </td>
  <td> <c:out value= "${elementCommande.heureCommande}" /> </td>
  <td> <em> <c:out value= "${elementCommande.nomMenu}" />  </em>  </td>
  <td>   <c:out value = "${elementCommande.prixMenu} dhs" />  </td>
  <td>  <a href="interfaceClientServlet?action=supprimer&idCommande=<c:out value= "${elementCommande.idCommande}" />">Supprimer</a>    </td>
    </tr> 
      </c:forEach>
  
  </tbody>
 </table>
</div>
</body>
</html>