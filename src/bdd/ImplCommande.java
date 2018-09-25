package bdd;

import java.io.*;
import java.sql.*;
import java.util.Vector;

import beans.Commande;
import beans.InfosCommande;

public class ImplCommande implements IntCommande {
	private Connection myConn ;
	public ImplCommande() throws FileNotFoundException, IOException, SQLException {
		new ConnectionBD();
	     myConn = ConnectionBD.getMyConn() ;
	}
	
	@Override
	public void addCommande(Commande c) throws SQLException {
		PreparedStatement myStmt = null ;
		try{
			
		    myStmt =  myConn.prepareStatement("insert into commande (dateCommande,heureCommande,idClient,idMenu) values(?,?,?,?)");
		    myStmt.setDate(1, c.getDateCommande());
		    myStmt.setTime(2, c.getHeureCommande());
		    myStmt.setInt(3, c.getIdClient());
		    myStmt.setInt(4, c.getIdMenu());
		    myStmt.executeUpdate();
		    System.out.println("------ Ajout avec succès --------");
		}
		finally{
			myStmt.close();
		}
	}

	@Override
	public void supprimerCommande(int idCommande) {
		String sql="Delete from commande WHERE idCommande= ? ";
		try {
			PreparedStatement ps = myConn.prepareStatement(sql);
			ps.setInt(1,idCommande);
			ps.execute();
			ps.close();
			 System.out.println("------ Suppression  reussie --------");
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	@Override
	public Vector<InfosCommande> listCommande() throws SQLException { // rETOURNE LA LISTE DES INFOS DE  COMMANDES DE LA JOURNEE LIMITEE A 20
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
	    Vector <InfosCommande> lcommande = new Vector <InfosCommande>();
		InfosCommande lc ;
		try {
		
			myStmt = myConn.prepareStatement("Select dateCommande , heureCommande , menu.nom , prix, utilisateur.nom from utilisateur,commande,menu where commande.idClient = idUtilisateur AND menu.idMenu = commande.idMenu  and to_days(now())-to_days(dateCommande) = 0 order by idCommande desc limit 20");
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				String dateCommande = myRs.getDate("dateCommande").toString();
				String heureCommande = myRs.getTime("heureCommande").toString();
				String nom = myRs.getString("menu.nom");
				double prix = myRs.getDouble("prix");
				String pseudo = myRs.getString("utilisateur.nom");
				lc = new InfosCommande(dateCommande,heureCommande,nom,prix,pseudo);
				lcommande.add(lc);
			}
		}
		finally {
			myStmt.close();
			myRs.close();
		}
		
		return lcommande;
		}
	public Vector<InfosCommande> listTCommande() throws SQLException { // RETOURNE TOUTES LES COMMANDES 
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
	    Vector <InfosCommande> lcommande = new Vector <InfosCommande>();
		InfosCommande lc ;
		try {
		
			myStmt = myConn.prepareStatement("Select dateCommande , heureCommande , menu.nom , prix, utilisateur.nom from utilisateur,commande,menu where commande.idClient = idUtilisateur AND menu.idMenu = commande.idMenu order by idCommande desc");
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				String dateCommande = myRs.getDate("dateCommande").toString();
				String heureCommande = myRs.getTime("heureCommande").toString();
				String nom = myRs.getString("menu.nom");
				double prix = myRs.getDouble("prix");
				String pseudo = myRs.getString("utilisateur.nom");
				lc = new InfosCommande(dateCommande,heureCommande,nom,prix,pseudo);
				lcommande.add(lc);
			}
		}
		finally {
			myStmt.close();
			myRs.close();
		}
		
		return lcommande;
		}
	public Vector<InfosCommande> notifCommande() throws SQLException { // RETOURNE TOUTES LES COMMANDES DE LA JOURNEE
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
	    Vector <InfosCommande> lcommande = new Vector <InfosCommande>();
		InfosCommande lc ;
		try {
		
			myStmt = myConn.prepareStatement("Select dateCommande , heureCommande , menu.nom , prix, utilisateur.nom ,datediff(now(),dateCommande) as absolu from utilisateur,commande,menu where commande.idClient = idUtilisateur AND menu.idMenu = commande.idMenu and (to_days(now()) - to_days(dateCommande))=0 ");
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				String dateCommande = myRs.getDate("dateCommande").toString();
				String heureCommande = myRs.getTime("heureCommande").toString();
				String nom = myRs.getString("menu.nom");
				double prix = myRs.getDouble("prix");
				String pseudo = myRs.getString("utilisateur.nom");
				lc = new InfosCommande(dateCommande,heureCommande,nom,prix,pseudo);
				lcommande.add(lc);
			}
		}
		finally {
			myStmt.close();
			myRs.close();
		}
		
		return lcommande;
		}
	@Override
	public Vector<InfosCommande> searchCommandeMc(String mc, int idClient) throws SQLException { // RECHERCHER UNE COMMANDE SELON SON MOT CLE 
		// TODO Auto-generated method stub
		mc =  "%" + mc.toLowerCase()  +"%" ;
		String sql="Select dateCommande , heureCommande , menu.nom , prix, utilisateur.nom  from utilisateur,commande,menu where commande.idMenu=menu.idMenu and commande.idClient = ? and utilisateur.idUtilisateur =?  and  menu.nom like ? or utilisateur.nom like ? or utilisateur.prenom like ? or utilisateur.pseudo like ?";
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
		Vector <InfosCommande> lcommande = new Vector <InfosCommande>();
		InfosCommande lc = new InfosCommande();
		try {	
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, idClient);
			myStmt.setInt(2, idClient);
			myStmt.setString(3, mc);
			myStmt.setString(4, mc);
			myStmt.setString(5, mc);
			myStmt.setString(6, mc);
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				String dateCommande = myRs.getDate("dateCommande").toString();
				String heureCommande = myRs.getTime("heureCommande").toString();
				String nom = myRs.getString("menu.nom");
				double prix = myRs.getDouble("prix");
				String pseudo = myRs.getString("utilisateur.nom");
				lc = new InfosCommande(dateCommande,heureCommande,nom,prix,pseudo);
				lcommande.add(lc);
			}
		}
		finally {
			myStmt.close();
			myRs.close();
		}
		return lcommande;
		}
	public Vector<InfosCommande> searchCommandeClient(int idClient) throws SQLException { // LES COMMANDES  DU JOUR D'UN   CLIENT 
		// TODO Auto-generated method stub
		String sql="Select idCommande , dateCommande , heureCommande , menu.nom , prix, utilisateur.nom from utilisateur , commande,menu where idUtilisateur = ? and commande.idClient = ? and menu.idMenu = commande.idMenu and  to_days(now()) - to_days(dateCommande) = 0 order by idCommande desc limit 7 ";
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
		Vector <InfosCommande> lcommande = new Vector <InfosCommande>();
		InfosCommande lc ;
		try {	
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, idClient);
			myStmt.setInt(2, idClient);
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				int idCommande = myRs.getInt("idCommande");
				String dateCommande = myRs.getDate("dateCommande").toString();
				String heureCommande = myRs.getTime("heureCommande").toString();
				String nom = myRs.getString("menu.nom");
				double prix = myRs.getDouble("prix");
				String pseudo = myRs.getString("utilisateur.nom");
				lc = new InfosCommande(dateCommande,heureCommande,nom,prix,pseudo);
				lc.setIdCommande(idCommande);
				lcommande.add(lc);
			}
		}
		finally {
			myStmt.close();
		}
		
		return lcommande;
	}
	public Vector<InfosCommande> listCommandeClient(int idClient) throws SQLException { // TOUTES LES COMMANDES D'UN CLIENT 
		// TODO Auto-generated method stub
		String sql="Select dateCommande , heureCommande , menu.nom , prix, utilisateur.nom from utilisateur , commande,menu where idUtilisateur = ? and commande.idClient = ? and menu.idMenu = commande.idMenu ";
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
		Vector <InfosCommande> lcommande = new Vector <InfosCommande>();
		InfosCommande lc ;
		try {	
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, idClient);
			myStmt.setInt(2, idClient);
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				String dateCommande = myRs.getDate("dateCommande").toString();
				String heureCommande = myRs.getTime("heureCommande").toString();
				String nom = myRs.getString("menu.nom");
				double prix = myRs.getDouble("prix");
				String pseudo = myRs.getString("utilisateur.nom");
				lc = new InfosCommande(dateCommande,heureCommande,nom,prix,pseudo);
				lcommande.add(lc);
			}
		}
		finally {
			myStmt.close();
		}
		
		return lcommande;
	}
	@Override
	public Commande convertToCommande(ResultSet myrs) throws SQLException {
		int idCommande = myrs.getInt("idCommande");
		int idClient = myrs.getInt("idClient");
		int idMenu = myrs.getInt("idMenu");
		Date dateCommande = myrs.getDate("dateCommande");
		Time heureCommande = myrs.getTime("heureCommande");
		Commande c =new Commande();
		c.setDateCommande(dateCommande);
		c.setHeureCommande(heureCommande);
		c.setIdClient(idClient);
		c.setIdMenu(idMenu);
		c.setIdCommande(idCommande);
		return c;
	}

}
