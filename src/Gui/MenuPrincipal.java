package Gui;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** Barre de menu de la fenêtre principale */
public class MenuPrincipal extends JMenuBar {
    /** Constructeur sans argument */
    public MenuPrincipal() {
	super();
	JMenu file = new JMenu("Fichier");

	JMenuItem quit = new JMenuItem("Quitter");
	quit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	    });
	
	file.add(quit);
	
	add(file);
    }
}

