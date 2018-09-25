package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.ImplCommande;
import bdd.ImplMenu;
import bdd.ImplUtilisateur;
import beans.Commande;
import beans.InfosCommande;
import beans.Utilisateur;

/**
 * Servlet implementation class InterfaceAdminServlet
 */
@WebServlet("/InterfaceAdminServlet")
public class InterfaceAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterfaceAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			ImplMenu baseMenu= new ImplMenu();
			ImplCommande baseCommande = new ImplCommande();
			ImplUtilisateur baseUtilisateur = new ImplUtilisateur();
			HttpSession session = request.getSession();
			Utilisateur u = (Utilisateur) session.getAttribute("admin");
			session.setAttribute("listCommandes", baseCommande.listCommande());
	    	 session.setAttribute("listTCommandes", baseCommande.listTCommande());
	    	 session.setAttribute("notificationCommande",baseCommande.notifCommande().size());
		     session.setAttribute("nbreCommande",baseCommande.listCommande().size());
		     session.setAttribute("nbreClient", baseUtilisateur.listUtilisateur().size());
	    	 session.setAttribute("idClient", u.getIdUtilisateur());
		     session.setAttribute("nbreMenu",baseMenu.listMenu().size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/interfaceAdmin.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		String recherche = search ;
		try {
			
			ImplMenu baseMenu = new ImplMenu();
			ImplCommande baseCommande = new ImplCommande();
			ImplUtilisateur baseUsers = new ImplUtilisateur();
			Vector<Commande> infosC = new Vector<Commande> () ;
			if(baseMenu.searchMenuMc(search)==null && /* baseCommande.searchCommandeMc(search)==null  &&*/ baseUsers.searchUtilisateurMc(search)==null) {
				search = "Aucun résultat correspondant à " + search ;
				request.setAttribute("message",search);
				request.setAttribute("rechercheMenu", null);
				request.setAttribute("rechercheCommande",null );
				request.setAttribute("rechercheClient", null);
				request.setAttribute("recherche", recherche);
				this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/resultatAdmin.jsp" ).forward( request, response );
			}
			else {
				request.setAttribute("recherche", recherche);
				request.setAttribute("rechercheMenu", baseMenu.searchMenuMc(search));
			//	request.setAttribute("rechercheCommande",baseCommande.searchCommandeMc(search) );
				request.setAttribute("rechercheClient", baseUsers.searchUtilisateurMc(search));
				this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/resultatAdmin.jsp" ).forward( request, response );
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
