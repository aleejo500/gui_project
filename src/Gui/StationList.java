package Gui;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Classe permettant d'utiliser une 
    liste avec les stations de metro */
public class StationList extends JList<String> {
    private DefaultListModel<String> listModel;

    /** Contructeur sans argument */
    public StationList() {
	listModel = new DefaultListModel<String>();
	try{ 
	    Conection con=new Conection();
	    
	    ResultSet rs = con.Requete1();
	    while (rs.next()){
		String name = rs.getString("nom");
		listModel.addElement(name);
	    }    
	} catch (SQLException ex) {
	    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
	} catch (Exception ex) {
	    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
	}
	setModel(listModel);
    }
}
