package beans;

import java.io.Serializable;
import java.sql.Date;

public class Utilisateur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String pseudo;
	private String mdp;
	private String CNE;
	private Date dateEnregistrement;
	private int quataUtilisateur;
	private boolean isClient;
	private int nbreCommande;
	private String mail ;
	private int idUtilisateur ;
	
	public String getMail() {
		return mail;
	}
	public Utilisateur() {
		nom="";
		prenom="";
		pseudo="";
		mdp="";
		CNE="";
		dateEnregistrement= new Date(System.currentTimeMillis());	
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", mdp=");
		builder.append(mdp);
		builder.append(", CNE=");
		builder.append(CNE);
		builder.append(", dateEnregistrement=");
		builder.append(dateEnregistrement);
		builder.append(", quataUtilisateur=");
		builder.append(quataUtilisateur);
		builder.append(", isClient=");
		builder.append(isClient);
		builder.append(", nbreCommande=");
		builder.append(nbreCommande);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", idUtilisateur=");
		builder.append(idUtilisateur);
		builder.append("]");
		return builder.toString();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getCNE() {
		return CNE;
	}
	public void setCNE(String cNE) {
		CNE = cNE;
	}
	public Date getDateEnregistrement() {
		return dateEnregistrement;
	}
	public void setDateEnregistrement(Date dateEnregistrement) {
		this.dateEnregistrement = dateEnregistrement;
	}
	public int getQuataUtilisateur() {
		return quataUtilisateur;
	}
	public void setQuataUtilisateur(int quataUtilisateur) {
		this.quataUtilisateur = quataUtilisateur;
	}
	public boolean isClient() {
		return isClient;
	}
   public void setClient(boolean isClient) {
		this.isClient = isClient;
	}	public int getNbreCommande() {
		return nbreCommande;
	}
	public void setNbreCommande(int nbreCommande) {
		this.nbreCommande = nbreCommande;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void setMail(String email) {
		this.mail = email ;
		
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

}
