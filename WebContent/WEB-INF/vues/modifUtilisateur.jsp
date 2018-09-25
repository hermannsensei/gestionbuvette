<%@ include file="enteteAdmin.jsp" %>
 <link href="style/user.css" rel="stylesheet">
<!-- <center style="background-image:url(./../images/cafe.jpg);"> 
 -->
<div class= "container">

            <form method="post" action="modificationUtilisateurServlet" class = "form-signin">
                     <label> Pseudo</label>
                    <input class="form-control" type="text" id="pseudo" name="pseudo" value = "${admin.pseudo }"  />
                    <br />
                    <label> Mot de passe </label>
                    <input class="form-control"  type="text" id="motDePasseClient" name="motDePasseClient" value="${admin.mdp }" size="30" maxlength="20" />
                    <br />
                    <label> Mail</label>
                    <input  class="form-control"  type="email" id="emailClient" name="emailClient" value="${admin.mail }" size="30" maxlength="60" />
                    <br />
                <input type="submit" value="Valider"  class ="btn btn-primary"/>
                <input type="reset" value="Remettre à zéro"  class = "btn btn-secondary"/> <br />
            </form>
        </div>
        
        <div class="container"> ${message}</div>

</center>


</body>
</html>