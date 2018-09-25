package beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Commande  implements Serializable{
	@Override
	public String toString() {
		return "Commande [dateCommande=" + dateCommande + ", heureCommande=" + heureCommande + ", idClient=" + idClient
				+ ", idMenu=" + idMenu + ", idCommande=" + idCommande + "]";
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateCommande;
	private Time heureCommande;
	private int idClient ;
	private int idMenu ;
	private int idCommande ;
	
	
	

	public Commande() {
		
	dateCommande =new Date(0);
	heureCommande = new Time(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	


	public int getIdClient() {
		return idClient;
	}



	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}



	public int getIdMenu() {
		return idMenu;
	}



	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}



	public int getIdCommande() {
		return idCommande;
	}



	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}



	public Time getHeureCommande() {
		return heureCommande;
	}



	public void setHeureCommande(Time heureCommande) {
		this.heureCommande = heureCommande;
	}



	public Date getDateCommande() {
		return dateCommande;
	}



	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

}
