package panels;

import java.util.ResourceBundle;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import gui.LigneList;
import gui.StationList;

/** Panel correspondant à une recherche en 
    selectionnant dans une JList */
public class RechercheList extends JPanel {
    /** Constructeur sans argument */
    public RechercheList() {
	JPanel lignes = new JPanel();
	JPanel stations = new JPanel();

	ResourceBundle label = ResourceBundle.getBundle("LabelBundle");

	lignes.setLayout(new BoxLayout(lignes, BoxLayout.Y_AXIS));
	lignes.add(new JLabel(label.getString("listSearchLineLabel")));
	lignes.add(new JScrollPane(new LigneList()));

	stations.setLayout(new BoxLayout(stations, BoxLayout.Y_AXIS));
	stations.add(new JLabel(label.getString("listSearchStationLabel")));
	stations.add(new JScrollPane(new StationList()));

	add(lignes);
	add(stations);
    }
}
