package Gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Classe contenant la méthode main du package Gui */
public class Main {
    public static void main(String [] args) {
	SwingUtilities.invokeLater(
				   new Runnable() {
				       public void run() {
					   JFrame fenetre = new JFrame("Recherche d'une station");
					   fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					   fenetre.setVisible(true);
				       }
				   });
    }
}
