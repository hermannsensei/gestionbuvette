<%@ include file="enteteAdmin.jsp" %>
<link href="style/menumodif.css" rel="stylesheet">
     <br />
       <center>
       <h2 > <font color ="silver"> <em> Modifier votre menu ici !</em> </font> </h2>
      <div class="container">
    
      <br />
     
     <form method="post" action="modificationMenuServlet" class="form-signin">
                       ${message} 
                    </br>
                    <input class ="form-control" type="text" id="nomMenu" name="nomMenu" value="${menu.nom }"   placeholder="Nom du menu..."/>
                    <br />
                     
                    <input class="form-control" type="text" id="prixMenu" name="prixMenu" value="${menu.prix}"  placeholder="Prix du menu" />
                    <br />
               
                <input type="submit" value="Valider" class="btn btn-primary"   />
                <input type="reset" value="Remettre � z�ro" class="btn  btn-danger"  /> <br />
            </form>
     </div> 
      </center>
       
</body>
</html>



