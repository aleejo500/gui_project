package Gui;

import java.awt.CardLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

/** Panel correspondant à l'onglet 
    de recherche d'une station de metro */
public class Recherche extends JPanel implements ItemListener {
    final static String TEXTUELLE = "Nom de station";
    final static String LIGNE = "Numéro de ligne";
    final static String APPROX = "Localisation approximative";
    private JPanel cards;

    /** Constructeur sans argument */
    public Recherche () {
	/* Creation de la combo box */
	JPanel comboBoxPane = new JPanel();
	String [] cbitems = {TEXTUELLE, LIGNE, APPROX};
	JComboBox cb = new JComboBox(cbitems);
	cb.setEditable(false);
	cb.addItemListener(this);
	comboBoxPane.add(cb);

	/* JPanel de la selection */
	JPanel select = new JPanel();
	select.add(new JLabel("Selectionnez le type de recherche : "));
	select.add(comboBoxPane);

	/* Panel de la fonction de recherche */
	cards = new JPanel(new CardLayout());
	cards.add(new RechercheText(), TEXTUELLE);
	cards.add(new RechercheList(), LIGNE);

	/* Ajout au panel courant */
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	add(select);
	add(cards);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
	CardLayout cl = (CardLayout)(cards.getLayout());
	cl.show(cards, (String)evt.getItem());
    }
}
