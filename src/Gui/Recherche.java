package Gui;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

/** Panel correspondant à l'onglet 
    de recherche d'une station de metro */
public class Recherche extends JPanel {
    /** Bouton qui lance la recherche */
    JButton searchButton;
    /** Le champ de texte dans lequel sera entré la recherche */
    JTextField searchField;
    /** Le champ dans lequel on peut selectionner la ligne */
    JScrollPane scrollLigne;

    /** Constructeur sans argument */
    public Recherche () {
	super(new FlowLayout());

	searchButton = new JButton("Rechercher");
	searchButton.addActionListener(new RechercheListener());
	searchField = new JTextField(30);
	scrollLigne = new JScrollPane(new LigneList());

	/* Ajout des composants */
	add(new JLabel("Recherche : "));
	add(searchField);
	add(searchButton);
	add(scrollLigne);
    }
}
