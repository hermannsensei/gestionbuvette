package servlets;

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
 * Servlet implementation class Stat
 */
@WebServlet("/Stat")
public class Stat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/stat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
