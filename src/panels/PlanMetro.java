package panels;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.util.LinkedList;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBConnection;
import utils.Station;

/** Image du métro parisien */
public class PlanMetro extends JPanel {
    /** La longueur de l'image */
    private int width;
    /** La hauteur de l'image */
    private int height;
    /** Les stations à afficher */
    private LinkedList<Station> stations;

    /** Constructeur */
    public PlanMetro(int width, int height) {
	setLayout(null);
	/* Init des attributs */
	this.width = width;
	this.height = height;
	try{
	    DBConnection con = new DBConnection();
	    stations = con.getMetroStations();
	    /* Dimensionnement du Panel */
	    setPreferredSize(new Dimension(width, height));
	    drawStations(con);
	} catch (SQLException ex) {
	    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
	} catch (Exception ex) {
	    Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    /** Méthode qui place les stations sur le panel */
    private void drawStations(DBConnection con) {
	try {
	    double xmin = con.getMinX();
	    double xmax = con.getMaxX();
	    double ymin = con.getMinY();
	    double ymax = con.getMaxY();

	    for(Station station : stations){
		double x = station.getX();
		double y = station.getY();
		
		int newx = 
		    new Double(Math.abs(width * (x - xmin) / (xmax - xmin))
			       ).intValue();
		int newy = 
		    new Double(Math.abs(height * (ymax - y) / (ymax - ymin))
			       ).intValue();

		JCheckBox jcb = new JCheckBox();
		jcb.setBounds(newx - 10, newy - 10, 20, 20);
		this.add(jcb);
	    }
	} catch(Exception e) {
	    System.err.println(e);
	}
    }
}
