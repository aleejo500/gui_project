package Gui;

import javax.swing.JList;
import javax.swing.DefaultListModel;

/** Classe permettant d'utiliser une 
    liste avec les lignes de metro */
public class LigneList extends JList {
    private DefaultListModel listModel;

    /** Contructeur sans argument */
    public LigneList() {
	super();
	listModel = new DefaultListModel();
	listModel.addElement("Ligne 1");
	listModel.addElement("Ligne 2");
	listModel.addElement("Ligne 3");
	
	setModel(listModel);
    }
}