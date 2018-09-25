package bdd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import beans.Menu;

public class ImplMenu implements IntMenu{
	private Connection myConn ;
	public ImplMenu() throws FileNotFoundException, IOException, SQLException {
		new ConnectionBD();
	     myConn = ConnectionBD.getMyConn() ;
	}
	@Override
	public void addMenu(Menu m) throws SQLException {
		PreparedStatement myStmt = null ;
		try{
			
		    myStmt =  myConn.prepareStatement("insert into menu (nom,prix,dateDajout) values(?,?,?)");
			// remplisage des lignes 
			myStmt.setString(1,m.getNom() );
			myStmt.setDouble(2,m.getPrix());
			myStmt.setString(3,m.getDateDajout());
			
		    myStmt.executeUpdate();
		    System.out.println("------ Ajout avec succès --------");
		}
		finally{
			close((Statement) myStmt);
		}
		
	}

	@Override
	public void supprimerMenu(Menu m) {
		String sql="Delete from menu WHERE nom like ? ";
		try {
			PreparedStatement ps = myConn.prepareStatement(sql);
			ps.setString(1, m.getNom());
			ps.execute();
			ps.close();
			 System.out.println("------ Suppression  reussie --------");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void modifierMenu(Menu m) {
		String sql = "UPDATE menu SET nom = ? , prix = ? , nbreCommande = ? WHERE nom like ? ";
		try {
			PreparedStatement ps = myConn.prepareStatement(sql);
			ps.setString(1, m.getNom());
			ps.setDouble(2, m.getPrix());
			ps.setInt(3, m.getCommande());
			ps.setString(4, m.getNom());
			ps.execute();
			ps.close();
			 System.out.println("------ Modification reussie --------");
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}

	@Override
	public Vector<Menu> listMenu() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
	    Vector <Menu> lmenu = new Vector <Menu>();
		try {
		
			myStmt = myConn.prepareStatement("select * from menu");
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				Menu m = convertToMenu(myRs);
				lmenu.add(m) ;	
			}
		}
		finally {
			close((Statement) myStmt);
		}
		
		return lmenu;
	}

	@Override
	public Vector<Menu> searchMenuMc(String mc) throws SQLException {
		mc = "%" + mc.toLowerCase() + "%" ;
		String sql="Select * from menu where nom like ? ";
		PreparedStatement myStmt = null;
		ResultSet myRs = null ;
		Vector <Menu> lmenu = new Vector <Menu>();
		try {	
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, mc);
			myRs =  myStmt.executeQuery();
			
			while (myRs.next()) {
				Menu m = convertToMenu(myRs);
				lmenu.add(m) ;	
			}
		}
		finally {
			close((Statement) myStmt);
		}
		
		return lmenu;
		}
	public Menu getMenu(int idMenu) throws SQLException {
		String sql = "select * from menu where idMenu = ? " ;
		PreparedStatement ps = myConn.prepareStatement(sql);
		ResultSet myRs ;
		Menu  m = new Menu();
		try {	
			ps.setInt(1, idMenu);
			myRs =  ps.executeQuery();
			
			if (myRs.next()) {
				 m = convertToMenu(myRs);
			}
		}
		finally {
			close((Statement) ps);
		}
		return m ;
	}

	@Override
	public Menu convertToMenu(ResultSet myrs) throws SQLException {
		String nom = myrs.getString("nom");
		double prix = myrs.getDouble("prix");
		String dateDajout = myrs.getString("dateDajout");
		int Commande = myrs.getInt("nbreCommande");
		int idMenu = myrs.getInt("idMenu");
		Menu m = new Menu();
		m.setCommande(Commande);
		m.setDateDajout(dateDajout);
		m.setIdMenu(idMenu);
		m.setNom(nom);
		m.setPrix(prix);
		
		return m;
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
