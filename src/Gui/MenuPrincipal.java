package Gui;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/** Barre de menu de la fenêtre principale */
public class MenuPrincipal extends JMenuBar {
    /** Constructeur sans argument */
    public MenuPrincipal() {
	super();
	JMenu [] menus = {
	    new JMenu("Fichier"),
	    new JMenu("Édition"),
	    new JMenu("Outils")};
	
	for(int i = 0; i < menus.length; i++) {
	    JMenu tmp = menus[i];
	    tmp.add(new JMenuItem("Premier"));
	    tmp.add(new JMenuItem("Deuxième"));
	    tmp.add(new JMenuItem("Troisième"));
	    this.add(tmp);
	}
    }
}
