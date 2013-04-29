package gui;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBConnection;
import panels.Recherche;
import utils.Ligne;
import java.util.LinkedList;

/** Classe permettant d'utiliser une 
    liste avec les lignes de metro */
public class LigneList extends JList<String> {
    private DefaultListModel<String> listModel;
    private LinkedList<Ligne> lignes;

    /** Contructeur sans argument */
    public LigneList() {
	listModel = new DefaultListModel<String>();
	try{ 
	    DBConnection con = new DBConnection();
	    lignes = con.getMetroLignes();
	    while(!lignes.isEmpty()) {
		listModel.addElement(lignes.pop().getNom()); 
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
