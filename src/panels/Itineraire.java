package panels;

import java.util.ResourceBundle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import listeners.ItineraireListener;

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
	setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	ResourceBundle label = ResourceBundle.getBundle("LabelBundle");
	ResourceBundle button = ResourceBundle.getBundle("ButtonBundle");

	itineraireButton = new JButton(button.getString("itinerarySearchButton"));
	itineraireButton.addActionListener(new ItineraireListener());

	departField = new JTextField(30);
	arriveeField = new JTextField(30);


	JLabel departLabel = new JLabel(label.getString("itineraryDepatureLabel"));
	JLabel arriveeLabel = new JLabel(label.getString("itineraryArrivalLabel"));

	c.gridx = 0;
	c.gridy = 0;
	c.fill = GridBagConstraints.BOTH;
	add(departLabel, c);

	c.gridx = 1;
	c.gridy = 0;
	c.fill = GridBagConstraints.BOTH;
	add(departField, c);

	c.gridx = 0;
	c.gridy = 1;
	c.fill = GridBagConstraints.BOTH;
	add(arriveeLabel, c);

	c.gridx = 1;
	c.gridy = 1;
	c.fill = GridBagConstraints.BOTH;
	add(arriveeField, c);

	c.gridx = 0;
	c.gridy = 2;
	c.gridwidth = 2;
	c.fill = GridBagConstraints.BOTH;
	add(itineraireButton, c);
    }
}
