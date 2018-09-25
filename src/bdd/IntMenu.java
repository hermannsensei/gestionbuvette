package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import beans.*;

public interface IntMenu {

	
	 public void addMenu(Menu m) throws SQLException ;
	 public void  modifierMenu(Menu m);
	 public void supprimerMenu(Menu m);
	 public Vector<Menu> listMenu() throws SQLException;
	 public Vector <Menu> searchMenuMc(String mc) throws SQLException ;
	 public Menu convertToMenu(ResultSet myrs) throws SQLException;
}
