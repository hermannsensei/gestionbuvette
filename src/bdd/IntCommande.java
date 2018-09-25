package bdd;

import java.sql.*;
import java.util.Vector;

import beans.*;

public interface IntCommande {
	 public void addCommande(Commande c) throws SQLException;
	 public Vector<InfosCommande> listCommande() throws SQLException;
	 public Vector<InfosCommande> searchCommandeMc(String mc,int idClient) throws SQLException;
	 public Commande convertToCommande(ResultSet myrs) throws SQLException;
	void supprimerCommande(int idCommande);

}
