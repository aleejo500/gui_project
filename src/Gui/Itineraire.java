package Gui;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

/** Panel correspondant à l'onglet 
    de recherche d'une station de metro */
public class Itineraire extends JPanel {
    /** Constructeur sans argument */
    public Itineraire () {
	super(new FlowLayout());
	this.add(new JLabel("Depart : "));
	this.add(new JTextField(30));
	this.add(new JLabel("Arrivé : "));
	this.add(new JTextField(30));
	this.add(new JButton("Tappe moi !"));
    }
}
