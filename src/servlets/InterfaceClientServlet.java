package servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.*;
import beans.*;

/**
 * Servlet implementation class InterfaceClientServlet
 */
@WebServlet("/InterfaceClientServlet")
public class InterfaceClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImplMenu baseMenu ;
	private ImplCommande baseCommande ;
	private ImplUtilisateur baseUtilisateur ;
       
    /**
     * @throws SQLException 
     * @throws IOException 
     * @throws FileNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public InterfaceClientServlet() throws FileNotFoundException, IOException, SQLException {
        super();
        baseMenu = new ImplMenu();
        baseCommande = new ImplCommande();
        baseUtilisateur = new ImplUtilisateur();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		    HttpSession session = request.getSession() ;
		    if(session.getAttribute("etat")!=null)
	          {

		    	Utilisateur u = (Utilisateur) session.getAttribute("client") ;
				int idClient = u.getIdUtilisateur() ;
				try {
								baseMenu = new ImplMenu() ;
								baseCommande = new ImplCommande();
								request.setAttribute("listMenu", baseMenu.listMenu());
								request.setAttribute("listCommandes", baseCommande.searchCommandeClient(idClient));
					} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				String action = request.getParameter("action");
				if(action!=null) {
					switch(action){

					case "infosclient" : {
						request.setAttribute("client", u);
		        	   this.getServletContext().getRequestDispatcher("/WEB-INF/vues/affichageClient.jsp").forward(request, response);
		        	   break ;
					}

					case "supprimer" : {

						int idCommande = Integer.parseInt(request.getParameter("idCommande"));
					    System.out.println(idCommande);
					    baseCommande.supprimerCommande(idCommande);
					      try {
						baseMenu = new ImplMenu();
						baseCommande = new ImplCommande();
						request.setAttribute("listMenu", baseMenu.listMenu());
						request.setAttribute("listCommandes", baseCommande.searchCommandeClient(idClient));
						session.setAttribute("listMenu", baseMenu.listMenu());
						session.setAttribute("listCommandes", baseCommande.searchCommandeClient(idClient));
						this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/interfaceClient.jsp" ).forward( request, response );
						break ;       
					      } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
		            			}
					}

					case "modifier" : {

						// A faire 
					}
					case "toutecommande" : {
					  try {
						baseMenu = new ImplMenu();
						baseCommande = new ImplCommande();
						if(baseCommande.listCommandeClient(idClient).size()==0) {
							String message = "Aucune commandes ...." ;
							request.setAttribute("message", message);
							this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/resultat.jsp" ).forward( request, response );
						}else {
							request.setAttribute("rechercheCommande", baseCommande.listCommandeClient(idClient));
							//request.setAttribute("rechercheCommande", baseCommande.searchCommandeMc(search));
							this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/resultat.jsp" ).forward( request, response );
						       } 
					     } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					     }
					  break ;
			         }

			        default : {
			        			    this.getServletContext().getRequestDispatcher("/WEB-INF/vues/interfaceClient.jsp").forward(request, response);
			        			    break ; 
			        }
				}
					}
				else{
						 this.getServletContext().getRequestDispatcher("/WEB-INF/vues/interfaceClient.jsp").forward(request, response);
				}
		    } 
		    else {
		    this.getServletContext().getRequestDispatcher("/WEB-INF/vues/authentification.jsp").forward(request, response);
		  }
		}
			        
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("etat")!=null){
		String pseudo  = request.getParameter("pseudo");
		String mdp  = request.getParameter("motDePasseClient");
		String email = request.getParameter("emailClient");
		String message ;

		if(pseudo!=null&&mdp!=null&&email!=null){
			Utilisateur u = new Utilisateur();
		u = (Utilisateur) session.getAttribute("client");
		if(u!=null) {
			if(u.getMdp() == mdp){
				message =  "Vous n'avez pas changer de mot de passe" ;
				request.setAttribute("message", message);
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/modifUtilisateur.jsp" ).forward( request, response );				
			}else {
				u.setClient(true);
				u.setMdp(mdp);
				u.setPseudo(pseudo);
				u.setMail(email);
				baseUtilisateur.modifierUtilisateur(u);
				session.invalidate();
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/authentification.jsp" ).forward( request, response );				
			}
		}


		} 
		  String commande = request.getParameter("menu");
		   String search = request.getParameter("search");
		
		 if(commande!=null) {
			Date t = new Date(System.currentTimeMillis());
			Time h = new Time(System.currentTimeMillis());
			Commande c = new Commande();
			Menu m;
			Utilisateur u = (Utilisateur) session.getAttribute("client") ;
			int idClient = u.getIdUtilisateur() ;
			  try {
		        baseMenu = new ImplMenu() ;
		        baseCommande = new ImplCommande();
				m = baseMenu.searchMenuMc(commande).get(0);
				c.setDateCommande(t);
				c.setHeureCommande(h);
				c.setIdClient(idClient);
				c.setIdMenu(m.getIdMenu());
				baseCommande = new ImplCommande() ;
				baseCommande.addCommande(c);
				request.setAttribute("h", h);
				session.setAttribute("listMenu", baseMenu.listMenu());
				session.setAttribute("listCommandes", baseCommande.searchCommandeClient(idClient));
				session.setAttribute("nbreCommande",baseCommande.listCommandeClient(idClient).size());
//				System.out.println(baseCommande.searchCommandeClient(idClient));
			    this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/interfaceClient.jsp" ).forward( request, response );

			    }
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
			
		  }
		  else if(search !=null) {
			try {
				Utilisateur u = (Utilisateur) session.getAttribute("client");
				baseMenu = new ImplMenu();
				baseCommande = new ImplCommande();
				if(baseCommande.searchCommandeMc(search,u.getIdUtilisateur()).size()==0) {
					search = "Aucun résultat correspondant à " + search ;
					request.setAttribute("affiche",search);
					this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/resultat.jsp" ).forward( request, response );
				}else {
					request.setAttribute("affiche", "Les commandes  ici ! ...");
					request.setAttribute("rechercheCommande", baseCommande.searchCommandeMc(search,u.getIdUtilisateur()));
					//request.setAttribute("rechercheCommande", baseCommande.searchCommandeMc(search));
					this.getServletContext().getRequestDispatcher( "/WEB-INF/vues/resultat.jsp" ).forward( request, response );
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  }
        else{
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/authentification.jsp").forward(request, response);

		   }
		

}

}
