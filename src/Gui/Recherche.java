package Gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/** Panel correspondant à l'onglet 
    de recherche d'une station de metro */
public class Recherche extends JPanel {
    /** Constructeur sans argument */
    public Recherche () {
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	/* Ajout des composants */
	add(new RechercheText());
	add(new RechercheList());
    }
}
