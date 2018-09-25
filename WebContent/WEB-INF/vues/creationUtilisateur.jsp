<%@ include file="enteteAdmin.jsp" %>
 <link href="style/user.css" rel="stylesheet">


    <center> 
     <h1>  Ajouter un client </h1> 
    <div>
            <form method="post" action="creationUtilisateurServlet" class="form-signin">
                ${ message } 
                   <br /> 
                    <input type="text" id="nomClient" name="nomClient" value="" class="form-control" placeholder="Nom du client" />
                    <!-- <br />  -->                   
                    
                    <input type="text" id="prenomClient" name="prenomClient" value="" class="form-control" placeholder="Prénom du client" />
                    <br />
                    <input type="text" id="pseudo" name="pseudo" value="" class="form-control" placeholder="Pseudo du client"  />
                   <!--  <br /> -->
                    <input type="password" id="motDePasseClient" name="motDePasseClient" class="form-control" placeholder="Mot de passe du client" />
                    <br />
                    <input type="text" id="CNE" name="CNE" value="" class="form-control" placeholder="CNE du client" />
                    <!-- <br /> -->
                    <input type="email" id="emailClient" name="emailClient" value="" class="form-control" placeholder="Email@example.com"   />
                    <input type="text" id="quotaDeCommande" name="quotaCommande" value="" class="form-control" placeholder="Quota de commande"  />
                <br />
                <input type="submit" class="btn btn-primary" value="Valider"  />
                <input type="reset" class="btn btn-danger"value="Remettre à zéro" /> <br />
            </form>
        </div>
    </center>
            </body>
</html>