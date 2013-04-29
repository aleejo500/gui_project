package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.Driver;

public class DBConnection {
    
    public Connection con;
    private PreparedStatement selectStmt;
    
    public DBConnection() 
	throws SQLException, ClassNotFoundException, Exception{
        Fconect();
    }
    

    private void Fconect() 
	throws ClassNotFoundException, SQLException, Exception {
	Class.forName("org.postgresql.Driver");
	con = DriverManager.getConnection(
		 "jdbc:postgresql://localhost:5432/RATP","amidouch","izan2112!");
    }
	
    public void FCLOSEconecta() throws ClassNotFoundException, SQLException {
	if (con != null) {
	    con.close();
	    con = null;        
	}
    }

    public ResultSet Requete1() 
	throws SQLException, ClassNotFoundException, Exception{
	//selectStmt = con.prepareStatement("select * from lignes where type='bus'");
	//selectStmt = con.prepareStatement("select * from lignes where numero like '14%' and type='metro'");    
	selectStmt = con.prepareStatement(
	    "SELECT lignes.numero,station.nom,station.commune,lignes.type "+
	    "FROM lignes, station " +
	    "WHERE lignes.id = station.id and lignes.type='metro';");
	ResultSet rs = selectStmt.executeQuery();
	return rs;
    }

    public ResultSet getMetroStations() 
	throws SQLException, ClassNotFoundException {
	selectStmt = con.prepareStatement(
		    "SELECT nom, latitude, longitude " +
		    "FROM station " +
		    "WHERE type = 'metro';");
	return selectStmt.executeQuery();
    }
}
