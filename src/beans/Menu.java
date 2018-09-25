package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Menu implements Serializable {
	
	@Override
	public String toString() {
		return "Menu [nom=" + nom + ", prix=" + prix + ", dateDajout=" + dateDajout + ", Commande=" + Commande
				+ ", idMenu=" + idMenu + "]";
	}


	private String nom;
	private double prix;
	private String dateDajout;
	private int Commande;
	private int idMenu ;


	public Menu() {
		
		nom ="";
		dateDajout ="";
		
	}






	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDateDajout() {
		return dateDajout;
	}
	public void setDateDajout(String dateDajout) {
		this.dateDajout = dateDajout;
	}
	public int getCommande() {
		return Commande;
	}
	public void setCommande(int commande) {
		Commande = commande;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public int getIdMenu() {
		return idMenu;
	}


	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

}
