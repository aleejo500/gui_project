package Gui;

import java.util.ResourceBundle;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

/** Panel correspondant à l'onglet 
    de recherche d'une station de metro */
public class RechercheText extends JPanel {
    /** Bouton qui lance la recherche */
    JButton searchButton;
    /** Le champ de texte dans lequel sera entré la recherche */
    JTextField searchField;

    /** Constructeur sans argument */
    public RechercheText () {
	/* Ajout des ressource bundle */
	ResourceBundle label = ResourceBundle.getBundle("LabelBundle");
       	ResourceBundle button = ResourceBundle.getBundle("ButtonBundle");

	/* Création des composants */
	searchButton = new JButton(button.getString("textSearchButton"));
	searchButton.addActionListener(new RechercheListener());
	searchField = new JTextField(30);
	
	/* Ajout des composants */
	add(new JLabel(label.getString("textSearchLabel")));
	add(searchField);
	add(searchButton);
    }
}
