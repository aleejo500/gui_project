package panels;

import java.util.ResourceBundle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import components.LigneList;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import utils.DBConnection;

/** Panel correspondant à une recherche en 
selectionnant dans une JList */
public class CommuneFiltre extends JPanel {
    private LinkedList stations;
    private DefaultListModel listModel;
    private JList stlist;
    /** Constructeur sans argument */
    public CommuneFiltre(String para) throws SQLException, ClassNotFoundException, Exception {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        ResourceBundle label = ResourceBundle.getBundle("LabelBundle");


        JLabel ligneLabel =new JLabel(label.getString("listSearchLineLabel"));
        //JScrollPane ligneList = new JScrollPane(new LigneList());
        JScrollPane ligneList;
        ligneList = new JScrollPane(new LigneList());

        JLabel stationLabel =new JLabel(label.getString("listSearchStationLabel"));
        //JScrollPane stationList = new JScrollPane(new StationList());
        listModel = new DefaultListModel();
        stlist=new JList();
       // String par;
        //par = "";
        DBConnection con = new DBConnection();
        stations = con.getMetroStations_commune(para);
        JScrollPane stationList;
        
       // stationList = new JScrollPane(stlist);
         stationList = new JScrollPane(stlist);
        
         while (!stations.isEmpty()) {
                listModel.addElement(stations.pop());
            }
        stlist.setModel(listModel);
       // setModel(listModel);
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(ligneLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(stationLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        add(ligneList, c);

        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        add(stationList, c);
    }
}
