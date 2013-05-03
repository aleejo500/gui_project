package frames;

import java.sql.SQLException;
import javax.swing.JFrame;
import panels.CommuneFiltre;

/** Classe qui affiche le plan du metro */
public class FenetreAprox extends JFrame {

    /** Constructeur */
    public FenetreAprox(String par) throws SQLException, ClassNotFoundException, Exception {
        setTitle("Recherche Approximative");
        getContentPane().add(new CommuneFiltre(par));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
