<%@ include file="enteteAdmin.jsp" %>
 <link href="style/creerMenu.css" rel="stylesheet">
   
 <br /> 
    <center> 
    <h2 > <font color ="silver"> <em> Créer  votre menu ici !</em> </font> </h2>
        <div class="container">
     <form method="post" action="creationMenuServlet" class="form-signin">
                       ${message} 
                    </br>
                    <input class ="form-control " type="text" id="nomMenu" name="nomMenu" value=""   placeholder="Nom du menu..."/>
                    <br />
                     
                    <input class="form-control " type="text" id="prixMenu" name="prixMenu" value=""  placeholder="Prix du menu" />
                    <br />
               
                <input type="submit" value="Valider" class="btn btn-primary"   />
                <input type="reset" value="Remettre à zéro" class="btn  btn-danger"  /> <br />
            </form>
            
        </div>
     
    
    </center>
     
       
</body>
</html>



