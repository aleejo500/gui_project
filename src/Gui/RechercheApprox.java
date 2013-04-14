package Gui;

import java.util.ResourceBundle;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

/** Panel correspondant à la recherche 
    approximative d'une station de metro */
public class RechercheApprox extends JPanel {
    /** Bouton qui lance la recherche */
    JButton searchButton;
    /** Le champ de texte dans lequel sera entré la recherche */
    JTextField searchField;

    /** Constructeur sans argument */
    public RechercheApprox () {
	/*  */
	ResourceBundle button = ResourceBundle.getBundle("ButtonBundle");
	ResourceBundle label = ResourceBundle.getBundle("LabelBundle");

	/* Création des composants */
	searchButton = new JButton(button.getString("approxSearchButton"));
	searchButton.addActionListener(new RechercheApproxListener());
	searchField = new JTextField(30);
	
	/* Ajout des composants */
	add(new JLabel(label.getString("approxSearchLabel")));
	add(searchField);
	add(searchButton);
    }
}
