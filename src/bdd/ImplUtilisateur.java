package bdd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;

import beans.*;

public class ImplUtilisateur implements IntUtilisateur{
	private Connection myConn ;
	public ImplUtilisateur() throws FileNotFoundException, IOException, SQLException {
		new ConnectionBD();
	     myConn = ConnectionBD.getMyConn() ;
	}
	@Override
	public void addUtilisateur(Utilisateur u) throws SQLException {
		PreparedStatement myStmt = null ;
		try{
		    myStmt =  myConn.prepareStatement("insert into utilisateur (nom,prenom,email,pseudo,mdp,CNE,dateEnregistrement,quotaCommande,isAgent) values(?,?,?,?,?,?,?,?,?)");
			// remplisage des lignes 
		    myStmt.setString(1,u.getNom() );
			myStmt.setString(2,u.getPrenom());
			myStmt.setString(3,u.getMail());
			myStmt.setString(4,u.getPseudo());
			myStmt.setString(5,u.getMdp());
			myStmt.setString(6,u.getCNE());
			myStmt.setDate(7, u.getDateEnregistrement());
			myStmt.setInt(8,u.getQuataUtilisateur());
			myStmt.setBoolean(9,u.isClient()); 
		    myStmt.executeUpdate();
		    System.out.println("------ Ajout avec succès --------");
		}
		finally{
			close((Statement) myStmt);
		}		
	}

	@Override
	public void modifierUtilisateur(Utilisateur u) {
		String sql = "UPDATE utilisateur SET mdp = ?, pseudo = ? WHERE idUtilisateur = ?";
		try {
			PreparedStatement ps = myConn.prepareStatement(sql);
			ps.setString(1, u.getMdp());
			ps.setString(2, u.getPseudo());
			ps.setInt(3, u.getIdUtilisateur());
			ps.execute();
			ps.close();
			 System.out.println("------ Modification reussie --------");
		} catch (SQLException e) {
			e.printStackTrace();
		}						
	}

	@Override
	public void supprimerUtilisateur(Utilisateur u) {
		String sql="Delete from utilisateur WHERE idUtilisateur = ? OR nom like ? ";
		try {
			PreparedStatement ps = myConn.prepareStatement(sql);
			ps.setInt(1, u.getIdUtilisateur());
			ps.setString(2,u.getNom());
			ps.execute();
			ps.close();
			 System.out.println("------ Suppression  reussie --------");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Vector<Utilisateur> listUtilisateur() throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
	    Vector <Utilisateur> lutilisateur = new Vector <Utilisateur>();
		try {
		
			myStmt = myConn.prepareStatement("select * from utilisateur");
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				Utilisateur u = convertToUtilisateur(myRs);
				lutilisateur.add(u) ;	
			}
		}
		finally {
			close((Statement) myStmt);
		}
		
		return lutilisateur;
	}

	@Override
	public Vector<Utilisateur> searchUtilisateurMc(String mc) throws SQLException {
		mc = "%" + mc.toLowerCase() + "%" ;
		String sql="Select * from utilisateur where nom like ? and isAgent = 0 ";
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
		Vector <Utilisateur> lutilisateur = new Vector <Utilisateur>();
		try {	
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, mc);
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				Utilisateur m = convertToUtilisateur(myRs);
				lutilisateur.add(m) ;	
			}
		}
		finally {
			close((Statement) myStmt);
		}
		
		return lutilisateur;
	}

	@Override
	public Utilisateur authentification(String login, String mdp) {
		// TODO Auto-generated method stub
		String sql ="select * from utilisateur where pseudo like ? and mdp like ?" ;
		Utilisateur u = null ;
		try {
			PreparedStatement ps = myConn.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, mdp);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				u = convertToUtilisateur(rs);
			}
			rs.close();
			ps.close();
		} catch (SQLException ee) {	ee.printStackTrace();	}
		return u;
	}

	@Override
	public Utilisateur convertToUtilisateur(ResultSet myrs) throws SQLException {
		int idUtilisateur = myrs.getInt("idUtilisateur");
		String nom = myrs.getString("nom");
		String prenom = myrs.getString("prenom");
		String mail = myrs.getString("email");
		String pseudo = myrs.getString("pseudo");
		String mdp = myrs.getString("mdp");
		String CNE = myrs.getString("CNE");
		Date dateEnregistrement = myrs.getDate("dateEnregistrement");
		int nbreCommande = myrs.getInt("nbreCommande");
		int quotaCommande = myrs.getInt("quotaCommande");
		boolean isAgent = myrs.getBoolean("isAgent") ;
		Utilisateur u = new Utilisateur();
		u.setClient(!isAgent);
		u.setCNE(CNE);
		u.setDateEnregistrement(dateEnregistrement);
		u.setIdUtilisateur(idUtilisateur);
		u.setMail(mail);
		u.setMdp(mdp);
		u.setNbreCommande(nbreCommande);
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setPseudo(pseudo);
		u.setQuataUtilisateur(quotaCommande);
		return u;
	}
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}

}
