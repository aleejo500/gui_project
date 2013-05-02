package components;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBConnection;
import panels.Recherche;
import utils.Station;
import java.util.LinkedList;

/** Classe permettant d'utiliser une 
liste avec les stations de metro */
public class StationList extends JList<String> {

    private DefaultListModel<String> listModel;
    private LinkedList<Station> stations;

    /** Contructeur sans argument */
    public StationList() {
        listModel = new DefaultListModel<String>();
        try {
            DBConnection con = new DBConnection();
            stations = con.getMetroStations();
            while (!stations.isEmpty()) {
                listModel.addElement(stations.pop().getNom());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
        setModel(listModel);
    }
}
