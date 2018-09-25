package servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.ImplUtilisateur;
import beans.Utilisateur;

/**
 * Servlet implementation class ModificationUtilisateurServlet
 */
@WebServlet("/ModificationUtilisateurServlet")
public class ModificationUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ImplUtilisateur baseUtilisateur ;
       
    /**
     * @throws SQLException 
     * @throws IOException 
     * @throws FileNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public ModificationUtilisateurServlet() throws FileNotFoundException, IOException, SQLException {
        super();
        baseUtilisateur =  new ImplUtilisateur();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur u =new Utilisateur()	 ;
		u = (Utilisateur) session.getAttribute("client");
		if(u==null) {
			u = (Utilisateur) session.getAttribute("admin");
		}
		
		if(u.isClient()) {
		   request.setAttribute("client", u);
		}else {
			request.setAttribute("admin", u);
		}
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/modifUtilisateur.jsp" ).forward( request, response );		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo  = request.getParameter("pseudo");
		String mdp  = request.getParameter("motDePasseClient");
		String email = request.getParameter("emailClient");
		String message ;
		Utilisateur u = new Utilisateur();
		HttpSession session = request.getSession();
		u = (Utilisateur) request.getAttribute("client");
		if(u!=null) {
			if(pseudo.equals(null)|| mdp.equals(null) ) {
				message = "Veuillez remplir les champs" ;
				request.setAttribute("message", message);
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/modifUtilisateur.jsp" ).forward( request, response );		
			}else if(u.getMdp() == mdp){
				message =  "Vous n'avez pas changer de mot de passe" ;
				request.setAttribute("message", message);
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/modifUtilisateur.jsp" ).forward( request, response );				
			}else {
				u.setClient(true);
				u.setMdp(mdp);
				u.setPseudo(pseudo);
				u.setMail(email);
				baseUtilisateur.modifierUtilisateur(u);
				session.setAttribute("client", u);
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/deconnexion.jsp" ).forward( request, response );				
			}
		}else {
			u = (Utilisateur) session.getAttribute("admin");
			if(pseudo.equals(null)|| mdp.equals(null) ) {
				message = "Veuillez remplir les champs" ;
				request.setAttribute("message", message);
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/modifUtilisateur.jsp" ).forward( request, response );		
			}else if(u.getMdp() == mdp){
				message =  "Vous n'avez pas changer de mot de passe" ;
				request.setAttribute("message", message);
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/modifUtilisateur.jsp" ).forward( request, response );				
			}else {
				u.setClient(false);
				u.setMdp(mdp);
				u.setPseudo(pseudo);
				u.setMail(email);
				baseUtilisateur.modifierUtilisateur(u);
				//session.setAttribute("client", u);
				session.setAttribute("admin", u);
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/deconnexion.jsp" ).forward( request, response );				
			
			}
			
		}
		

}
	}
