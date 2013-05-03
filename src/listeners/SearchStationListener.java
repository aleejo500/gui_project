/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import utils.DBConnection;
import utils.Station;

/**
 *
 * @author amidouch
 */
public class SearchStationListener extends KeyAdapter {

    /**
     * Connection à la base de donnée permettant de faire les requêtes.
     */
    private DBConnection connection;
    /**
     * Le JTextField ou l'on rentre la recherche.
     */
    private JComboBox search;
    /**
     * Une liste chainée de stations.
     */
    private LinkedList<Station> stations;

    /**
     * Le constructeur.
     *
     * @param search La JComboBox à utiliser pour donner des suggestions
     */
    public SearchStationListener(JComboBox<String> search) {
        this.search = search;
        try {
            connection = new DBConnection();
            stations = connection.getMetroStations();
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String srch = ((JTextField) search.getEditor().getEditorComponent())
                .getText();
        DefaultComboBoxModel<String> model =
                (DefaultComboBoxModel<String>) search.getModel();
        model.removeAllElements();
        model.addElement(srch);
        if (srch.length() > 2) {
            for (Station st : stations) {
                String lowst = st.getNom().toLowerCase();
                String lowsrch = srch.toLowerCase();
                if ((lowst.startsWith(lowsrch))
                        && (!st.getNom().equals(srch))) {
                    model.addElement(st.getNom());
                }
            }
        }
        search.setModel(model);
        search.setPopupVisible(false);
        search.setPopupVisible(true);
    }
}
