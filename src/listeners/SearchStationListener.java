/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.Collator;
import java.util.LinkedList;
import javax.swing.ComboBoxModel;
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
        if ((e.getKeyCode() != KeyEvent.VK_UP)
                && (e.getKeyCode() != KeyEvent.VK_DOWN)
                && (e.getKeyCode() != KeyEvent.VK_ENTER)) {
            String srch = ((JTextField) search.getEditor().getEditorComponent())
                    .getText();
            search.setModel(filterStations(srch));
            search.setPopupVisible(false);
            if (!srch.isEmpty()) {
                search.setPopupVisible(true);
            }
        }
    }

    /**
     * Filtre les stations pour ne garder que celles qui correspondent à la
     * recherche.
     * @param srch La recherche entrée par l'utilisateur
     * @return Un ComboBoxModel contenant les stations retenues
     */
    private ComboBoxModel<String> filterStations(String srch) {
        DefaultComboBoxModel<String> model;
        model = DefaultComboBoxModel.class.cast(search.getModel());

        model.removeAllElements();
        model.addElement(srch);
        if (srch.length() > 2) {
            for (Station st : stations) {
                if (SearchStationListener.areAlike(srch, st.getNom())) {
                    model.addElement(st.getNom());
                }
            }
        }
        
        return model;
    }

    /**
     * Compare deux chaines de caractère pour voir si elles sont semblables.
     *
     * @param src La chaine source
     * @param dest La chaine destination
     * @return Un booléen qui indique si les chaines sont semblables ou non
     */
    private static boolean areAlike(String src, String dest) {
        /* Configuration de la force de comparaison */
        Collator mycoll = Collator.getInstance();
        mycoll.setStrength(Collator.PRIMARY);

        /* Comparaison */
        if ((mycoll.compare(src,
                dest.substring(0, Math.min(dest.length(), src.length()))) == 0)
                && (!dest.equals(src))) {
            return true;
        }

        return false;
    }
}
