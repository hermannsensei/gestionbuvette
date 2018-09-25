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
 * Servlet implementation class CreationMenuServlet
 */
@WebServlet("/CreationMenuServlet")
public class CreationMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/creationMenu.jsp" ).forward( request, response );			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomMenu = request.getParameter("nomMenu");
		double prixMenu = 0 ;
		Date t = new Date(System.currentTimeMillis());
		String message ;
		if(nomMenu.isEmpty() || request.getParameter("prixMenu")== null) {
			 message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creationMenu.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
			    request.setAttribute("message", message);
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/creationMenu.jsp" ).forward( request, response );			
		}
		else {
			try {
				ImplMenu baseMenu = new ImplMenu();
				prixMenu = Double.parseDouble(request.getParameter("prixMenu"));	
				Menu m = new Menu();
				m.setDateDajout(t.toString());
				m.setNom(nomMenu);
				m.setPrix(prixMenu);
				baseMenu.addMenu(m);
				System.out.println(m);
				System.out.println("***----- les menus de la base de données ----- ******");
				System.out.println(baseMenu.listMenu()+ "\n");
				this.getServletContext().getRequestDispatcher("/WEB-INF/vues/interfaceAdmin.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
