package bdd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
	
	private static Connection myConn ;

	public ConnectionBD() throws FileNotFoundException, IOException, SQLException{
		
		String user = "root" ;
		String password = "" ;
		String dburl = "jdbc:mysql://localhost:3306/buvette" ;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			setMyConn(DriverManager.getConnection(dburl, user, password));
			System.out.println("Connection à la base de donnée buvette réussie ");
		}catch(ClassNotFoundException c){
			System.out.println("Error loading driver : " + c);
		}
		
	}
	

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		new ConnectionBD() ;
		
	}


	public static Connection getMyConn() {
		return myConn;
	}


	public void setMyConn(Connection myConn) {
		ConnectionBD.myConn = myConn;
	}

}
