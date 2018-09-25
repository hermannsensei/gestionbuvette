package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.*;
import beans.*;

/**
 * Servlet implementation class CreationUtilisateurServlet
 */
@WebServlet("/CreationUtilisateurServlet")
public class CreationUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/creationUtilisateur.jsp" ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String nom  = request.getParameter("nomClient");
	String prenom  = request.getParameter("prenomClient");
	String pseudo  = request.getParameter("pseudo");
	String mdp  = request.getParameter("motDePasseClient");
	String CNE  = request.getParameter("CNE");
	//Date enregistrement = request.getParameter("dateEnregistrementClient");
	int quota ;
     /* Conversion de la date en String selon le format défini */
	Date t = new Date(System.currentTimeMillis());
	//String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS").format(t);
	String email = request.getParameter("emailClient");
	if(request.getParameter("quotaClient")!=null)
        quota = Integer.parseInt(request.getParameter("quotaClient"));
	else {
		quota = 10;
	}
	String message = null ;
	
	if(nom.isEmpty() || prenom.isEmpty() || pseudo.isEmpty() || mdp.isEmpty() || CNE.isEmpty()) {
        message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creationUtilisateur.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
	    request.setAttribute("message", message);
	    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/creationUtilisateur.jsp" ).forward( request, response );		
	    
	}else {
		Utilisateur client = new Utilisateur() ;
		client.setCNE(CNE);
		//client.setDateEnregistrement(dateEnregistrement);
		client.setMdp(mdp);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setPseudo(pseudo);
		client.setQuataUtilisateur(quota);
		request.setAttribute("client", client);
		request.setAttribute("message", message);
		client.setMail(email);
		client.setDateEnregistrement(t);
		try {
			ImplUtilisateur baseUtilisateur = new ImplUtilisateur();
			baseUtilisateur.addUtilisateur(client);
			System.out.println(baseUtilisateur.authentification(client.getPseudo(), client.getMdp()));
			System.out.println("------Les utilisateurs sont ----- ");
			System.out.println(baseUtilisateur.listUtilisateur());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(client);
		//client.setDateEnregistrement(t);
	    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/interfaceAdmin.jsp" ).forward( request, response );		
		}
	}

}
