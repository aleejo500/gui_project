package Gui;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

/** Panel correspondant à l'onglet 
    de recherche d'une station de metro */
public class Recherche extends JPanel {
    /** Constructeur sans argument */
    public Recherche () {
	super(new FlowLayout());
	this.add(new JLabel("Recherche : "));
	this.add(new JTextField(30));
	this.add(new JButton("Rechercher"));
    }
}
