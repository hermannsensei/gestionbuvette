package beans;

import java.io.Serializable;

public class InfosCommande implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCommande ;
private String dateCommande ;
 private String heureCommande ;
 private String nomMenu ;
 private double prixMenu ;
 private String pseudo ;
public String getDateCommande() {
	return dateCommande;
}
public void setDateCommande(String dateCommande) {
	this.dateCommande = dateCommande;
}
public String getHeureCommande() {
	return heureCommande;
}
public void setHeureCommande(String heureCommande) {
	this.heureCommande = heureCommande;
}
public String getNomMenu() {
	return nomMenu;
}
public void setNomMenu(String nomMenu) {
	this.nomMenu = nomMenu;
}
public double getPrixMenu() {
	return prixMenu;
}
public void setPrixMenu(double prixMenu) {
	this.prixMenu = prixMenu;
}
public String getPseudo() {
	return pseudo;
}
public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
}
@Override
public String toString() {
	return "InfosCommande [dateCommande=" + dateCommande + ", heureCommande=" + heureCommande + ", nomMenu=" + nomMenu
			+ ", prixMenu=" + prixMenu + ", pseudo=" + pseudo + "]";
}
public InfosCommande(String dateCommande, String heureCommande, String nomMenu, double prixMenu, String pseudo) {
	super();
	this.dateCommande = dateCommande;
	this.heureCommande = heureCommande;
	this.nomMenu = nomMenu;
	this.prixMenu = prixMenu;
	this.pseudo = pseudo;
}
public InfosCommande() {
	
}
public int getIdCommande() {
	return idCommande;
}
public void setIdCommande(int idCommande) {
	this.idCommande = idCommande;
}
}
