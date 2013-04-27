package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

/** Classe qui affiche le plan du metro */
public class FenetreMetro extends JFrame {
    /** Constructeur */
    public FenetreMetro() {
	setTitle("Plan du métro");
	add(new JLabel("Prochainement ici il y aura le plan du métro parisien :)"));
	pack();
	setLocationRelativeTo(null);
	setVisible(true);
    }
}
