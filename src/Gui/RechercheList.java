package Gui;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/** Panel correspondant à une recherche en 
    selectionnant dans une JList */
public class RechercheList extends JPanel {
    /** Constructeur sans argument */
    public RechercheList() {
	super(new FlowLayout());
	add(new JScrollPane(new LigneList()));
    }
}