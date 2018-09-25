package bdd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
//import java.sql.Time;


public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
	//	ImplCommande c = new ImplCommande();
//		ImplMenu m = new ImplMenu();
//		ImplUtilisateur u = new ImplUtilisateur();
//		java.sql.Date dateEnregistrement = (java.sql.Date) new Date(System.currentTimeMillis());
//		//Time heure = new Time(dateEnregistrement.getTime());
//		Utilisateur user = new Utilisateur();
//		user.setClient(true);
//		user.setCNE("EB170752");
//		user.setDateEnregistrement(dateEnregistrement);
//		user.setMail("hermannsensei@gmail.com");
//		user.setMdp("123soleil");
//		user.setNbreCommande(20);
//		user.setNom("sensei");
//		user.setPrenom("h");
//		user.setPseudo("h_sensei");
//		user.setQuataUtilisateur(10);
//		Utilisateur userb = new Utilisateur();
//		userb.setClient(false);
//		userb.setCNE("EB17772");
//		userb.setDateEnregistrement(dateEnregistrement);
//		userb.setMail("sam33hp@gmail.com");
//		userb.setMdp("123mars");
//		userb.setNbreCommande(10);
//		userb.setNom("GUABA");
//		userb.setPrenom("Saida");
//		userb.setPseudo("saida");
//		userb.setQuataUtilisateur(20);
//		Menu panini = new Menu();
//		panini.setDateDajout(dateEnregistrement.toString());
//		panini.setNom("PANINI");
//		panini.setPrix(15);
//		Menu fromage = new Menu();
//		fromage.setDateDajout(dateEnregistrement.toString()); 
//		fromage.setNom("FROMAGE");
//		fromage.setPrix(8);
////		u.addUtilisateur(user);
//		//u.addUtilisateur(userb);
////		m.addMenu(panini);
////		m.addMenu(fromage);
////		System.out.println(u.listUtilisateur());
////		System.out.println(m.listMenu());
//		//Utilisateur moi = u.authentification("h_sensei ", "123soleil");
//		Menu choix = m.getMenu(2);
//		choix.setNom("PANINI DINDE");
//		choix.setPrix(15);
////		Menu mm = m.getMenu(2);
////		Commande cm = new Commande();
////		cm.setDateCommande(dateEnregistrement);
////		cm.setHeureCommande(heure);
////		cm.setIdClient(moi.getIdUtilisateur());
////		cm.setIdMenu(choix.getIdMenu());
////		Commande cd = new Commande();
////		cd.setDateCommande(dateEnregistrement);
////		cd.setHeureCommande(heure);
////		cd.setIdClient(moi.getIdUtilisateur());
////		cd.setIdMenu(mm.getIdMenu());
////		c.addCommande(cm);
////		c.addCommande(cd);
////		choix.setIdMenu(2);
//		m.modifierMenu(choix);
////		System.out.println(m.listMenu());
//	//	u.supprimerUtilisateur(userb);
//		System.out.println("il y a " + u.listUtilisateur().size() + " utilisateurs qui sont " + u.listUtilisateur());
//		System.out.println(m.listMenu());
//		
		
		ImplCommande bb= new ImplCommande();
		ImplUtilisateur uu = new ImplUtilisateur();
		System.out.println(bb.listCommande().size());
		System.out.println(uu.listUtilisateur());
		

	}

}
