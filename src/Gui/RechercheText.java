package Gui;

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
		/* Création des composants */
		searchButton = new JButton("Rechercher");
		searchButton.addActionListener(new RechercheListener());
		searchField = new JTextField(30);

		/* Ajout des composants */
		add(new JLabel("Station : "));
		add(searchField);
		add(searchButton);
    }
}
