<%@ include file="enteteClient.jsp" %>
 <link href="style/user.css" rel="stylesheet">

 <center>
<div class= "container">

            <form method="post" action="interfaceClientServlet" class = "form-signin">
                     <label> Pseudo</label>
                    <input class="form-control" type="text" id="pseudo" name="pseudo" value = "${client.pseudo }"  />
                    <br />
                    <label> Mot de passe </label>
                    <input class="form-control"  type="text" id="motDePasseClient" name="motDePasseClient" value="${client.mdp }" size="30" maxlength="20" />
                    <br />
                    <label> Mail</label>
                    <input  class="form-control"  type="email" id="emailClient" name="emailClient" value="${client.mail }" size="30" maxlength="60" />
                    <br />
                <input type="submit" value="Valider"  class ="btn btn-primary"/>
                <input type="reset" value="Remettre à zéro"  class = "btn btn-secondary"/> <br />
            </form>
        </div>
        
        <div class="container"> ${message}</div>

</center>


</body>
</html>