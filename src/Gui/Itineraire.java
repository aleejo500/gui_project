package Gui;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

/** Panel correspondant à l'onglet 
    de recherche d'une station de metro */
public class Itineraire extends JPanel {
    /** Bouton qui permet de lancer la recherche d'itinéraire */
    private JButton itineraireButton;
    /** Champ de texte qui permet d'entrer le départ */
    private JTextField departField;
    /** Champ de texte qui permet d'entrer l'arrivé */
    private JTextField arriveeField;

    /** Constructeur sans argument */
    public Itineraire () {
	/* On applique le FlowLayout à notre JComponent */
	super(new FlowLayout());

	itineraireButton = new JButton("Tappe moi !");
	itineraireButton.addActionListener(new ItineraireListener());

	departField = new JTextField(30);
	arriveeField = new JTextField(30);

	add(new JLabel("Départ : "));
	add(departField);
	add(new JLabel("Arrivée : "));
	add(arriveeField);
	add(itineraireButton);
    }
}
