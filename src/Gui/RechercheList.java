package Gui;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

/** Panel correspondant à une recherche en 
    selectionnant dans une JList */
public class RechercheList extends JPanel {
    /** Constructeur sans argument */
    public RechercheList() {
	JPanel lignes = new JPanel();
	JPanel stations = new JPanel();

	lignes.setLayout(new BoxLayout(lignes, BoxLayout.Y_AXIS));
	lignes.add(new JLabel("Numéro de la ligne"));
	lignes.add(new JScrollPane(new LigneList()));

	stations.setLayout(new BoxLayout(stations, BoxLayout.Y_AXIS));
	stations.add(new JLabel("Nom de la station"));
	stations.add(new JScrollPane(new StationList()));

	add(lignes);
	add(stations);
    }
}
