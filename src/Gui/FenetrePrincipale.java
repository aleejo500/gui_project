package Gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/** Fenêtre principale de l'application */
public class FenetrePrincipale extends JFrame {
    private JTabbedPane fonctionnalites;

    /** Constructeur sans argument */
    FenetrePrincipale() {
	super("TransParix");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fonctionnalites = new JTabbedPane();
	fonctionnalites.add("Rechercher", new Recherche());
	fonctionnalites.add("Itinéraire", new Itineraire());
	getContentPane().add(fonctionnalites);
	pack();
	setVisible(true);
    }
}
