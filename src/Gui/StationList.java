package Gui;

import javax.swing.JList;
import javax.swing.DefaultListModel;

/** Classe permettant d'utiliser une 
    liste avec les stations de metro */
public class StationList extends JList {
    private DefaultListModel listModel;

    /** Contructeur sans argument */
    public StationList() {
	listModel = new DefaultListModel();
	listModel.addElement("Station 1");
	listModel.addElement("Station 2");
	listModel.addElement("Station 3");
	
	setModel(listModel);
    }
}
