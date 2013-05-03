package panels;

import frames.FenetreAprox;
import java.util.ResourceBundle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import utils.DBConnection;

/** Panel correspondant à la recherche 
approximative d'une station de metro */
public class RechercheApprox extends JPanel implements ItemListener{

    /** Bouton qui lance la recherche */
    JButton searchButton;
    /** Le champ de texte dans lequel sera entré la recherche */
    //private JComboBox searchField;
    private ResultSet res;
    public  String para;
    

    /** Constructeur sans argument */
    public RechercheApprox() {
        /* Gestion du layout */
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        /* Creation des Bundles */
        ResourceBundle button = ResourceBundle.getBundle("ButtonBundle");
        ResourceBundle label = ResourceBundle.getBundle("LabelBundle");

        /* Création des composants */
        searchButton = new JButton(button.getString("approxSearchButton"));
        
        //searchField = new JTextField(30);
        JComboBox searchField;
        searchField = new JComboBox();
        
       
           try {
            DBConnection con = new DBConnection();
            res = con.Requete_comm();
            while (res.next()) {
               String comm = res.getString("commune");
               searchField.addItem(comm);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        para=searchField.getSelectedItem().toString();
        searchField.addItemListener(this);
        /* Ajout des composants */
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(new JLabel(label.getString("approxSearchLabel")), c);

        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(searchField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        searchButton.addActionListener(new RechercheApproxListener1(para));
        add(searchButton, c);
    }

    
    @Override
    public void itemStateChanged(ItemEvent evt) {
        para=(String) evt.getItem();
 
    }
 

     
     
private class RechercheApproxListener1 implements ActionListener {

      
//String param;
    
/*RechercheApproxListener(String par){
para=par;
}*/
 public RechercheApproxListener1(String par) {
       //param=par; //To change body of generated methods, choose Tools | Templates.
  System.out.println("Va chercher approximativement ! " + par ); 
 }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
  //          System.out.println("Va chercher approximativement !");
            try {
                
                FenetreAprox fm = new FenetreAprox(para);
            } catch (SQLException ex) {
                Logger.getLogger(RechercheApprox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RechercheApprox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(RechercheApprox.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
}