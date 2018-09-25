package bdd;

import beans.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public interface IntUtilisateur {
 public void addUtilisateur(Utilisateur u) throws SQLException ;
 public void modifierUtilisateur(Utilisateur u);
 public void supprimerUtilisateur(Utilisateur u);
 public Vector<Utilisateur> listUtilisateur() throws SQLException;
 public Vector <Utilisateur> searchUtilisateurMc(String mc) throws SQLException  ;
 public Utilisateur authentification(String login , String mdp) ;
 public Utilisateur convertToUtilisateur(ResultSet myrs) throws SQLException;
}
