package Gui;

import javax.swing.BoxLayout;
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
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	
	itineraireButton = new JButton("Tappe moi !");
	itineraireButton.addActionListener(new ItineraireListener());

	departField = new JTextField(30);
	arriveeField = new JTextField(30);

	JPanel depart = new JPanel();
	depart.add(new JLabel("Départ : "));
	depart.add(departField);

	JPanel arrive = new JPanel();
	arrive.add(new JLabel("Arrivée : "));
	arrive.add(arriveeField);

	add(depart);
	add(arrive);
	add(itineraireButton);
    }
}
