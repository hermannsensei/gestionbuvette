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

import bdd.ImplCommande;
import bdd.ImplMenu;
import bdd.ImplUtilisateur;
import beans.Utilisateur;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Utilisateur u ;
    private ImplUtilisateur baseUtilisateurs ;
    private ImplMenu baseMenu ;
	private ImplCommande baseCommande ;
    /**
     * @throws SQLException 
     * @throws IOException 
     * @throws FileNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() throws FileNotFoundException, IOException, SQLException {
        super();
        baseUtilisateurs = new ImplUtilisateur();
        baseMenu = new ImplMenu();
	    baseCommande = new ImplCommande();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession() ;
		String etat = request.getParameter("etat");
		if(etat!=null) {
			session.invalidate();
		}
		
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/authentification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  connexion ;
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
//		try {
//			baseUtilisateurs = new ImplUtilisateur();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	if(baseUtilisateurs.authentification(login, mdp)!=null) {		
			 try {
				 baseUtilisateurs = new ImplUtilisateur();
			     baseMenu = new ImplMenu();
				 baseCommande = new ImplCommande();
				 u = baseUtilisateurs.authentification(login, mdp) ;
				 HttpSession session = request.getSession();
				 session.setAttribute("etat", "connecte");
				 session.setAttribute("listUtilisateurs", baseUtilisateurs.listUtilisateur());
		    	 session.setAttribute("listMenu", baseMenu.listMenu());				    
				     if(u.isClient()) {
				    	 session.setAttribute("client", u);
						 session.setAttribute("idClient", u.getIdUtilisateur());
					     session.setAttribute("listCommandes", baseCommande.searchCommandeClient(u.getIdUtilisateur()));
					     session.setAttribute("nbreCommande",baseCommande.listCommandeClient(u.getIdUtilisateur()).size());
					     session.setAttribute("toutesCommande",baseCommande.listCommandeClient(u.getIdUtilisateur()));
					     this.getServletContext().getRequestDispatcher("/WEB-INF/vues/interfaceClient.jsp").forward(request, response);
				     }
				     else {
				    	 session.setAttribute("admin",u);
				    	 session.setAttribute("listCommandes", baseCommande.listCommande());
				    	 session.setAttribute("listTCommandes", baseCommande.listTCommande());
				    	 session.setAttribute("notificationCommande",baseCommande.notifCommande().size());
					     session.setAttribute("nbreCommande",baseCommande.listCommande().size());
					     session.setAttribute("nbreClient", baseUtilisateurs.listUtilisateur().size());
				    	 session.setAttribute("idClient", u.getIdUtilisateur());
					     session.setAttribute("nbreMenu",baseMenu.listMenu().size());
					this.getServletContext().getRequestDispatcher("/WEB-INF/vues/interfaceAdmin.jsp").forward(request, response);
				     }

				} catch (SQLException e) {
					// TODO Auto-generated catch block
				 e.printStackTrace();
			} 
			 }				 
			else {
				connexion = "Mot de passe ou identifiant incorrects" ;
				request.setAttribute("connexion", connexion);
				this.getServletContext().getRequestDispatcher("/WEB-INF/vues/authentification.jsp").forward(request, response);
			}
		}
		
	}


