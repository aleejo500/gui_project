package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class DBConnection {

    public Connection con;
    private PreparedStatement selectStmt;

    public DBConnection()
            throws SQLException, ClassNotFoundException, Exception {
        Fconect();
    }

    private void Fconect()
            throws ClassNotFoundException, SQLException, Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/RATP", "amidouch", "izan2112!");
    }

    public void FCLOSEconecta() throws ClassNotFoundException, SQLException {
        if (con != null) {
            con.close();
            con = null;
        }
    }

    public ResultSet Requete1()
            throws SQLException, ClassNotFoundException, Exception {
        //selectStmt = con.prepareStatement("select * from lignes where type='bus'");
        //selectStmt = con.prepareStatement("select * from lignes where numero like '14%' and type='metro'");    
        selectStmt = con.prepareStatement(
                "SELECT lignes.numero,station.nom,station.commune,lignes.type "
                + "FROM lignes, station "
                + "WHERE lignes.id = station.id and lignes.type='metro';");
        ResultSet rs = selectStmt.executeQuery();
        return rs;
    }

    /** Les stations de metro */
    public LinkedList<Station> getMetroStations()
            throws SQLException, ClassNotFoundException {
        selectStmt = con.prepareStatement(
                "SELECT * "
                + "FROM station "
                + "WHERE type = 'metro';");
        ResultSet results = selectStmt.executeQuery();
        LinkedList<Station> stations = new LinkedList<Station>();
        while (results.next()) {
            stations.add(new Station(results.getInt("id"),
                    results.getDouble("latitude"),
                    results.getDouble("longitude"),
                    results.getString("nom"),
                    results.getString("commune"),
                    results.getString("type")));
        }
        return stations;
    }

    /** Les lignes de metro */
    public LinkedList<Ligne> getMetroLignes()
            throws SQLException, ClassNotFoundException {
        selectStmt = con.prepareStatement(
                "SELECT * "
                + "FROM lignes "
                + "WHERE type = 'metro';");
        ResultSet results = selectStmt.executeQuery();
        LinkedList<Ligne> lignes = new LinkedList<Ligne>();
        while (results.next()) {
            lignes.add(new Ligne(results.getInt("id"),
                    results.getString("numero"),
                    results.getString("type")));
        }
        return lignes;
    }

    public double getMinX()
            throws SQLException, ClassNotFoundException {
        selectStmt = con.prepareStatement(
                "SELECT min(longitude) "
                + "FROM station "
                + "WHERE type='metro';");
        ResultSet results = selectStmt.executeQuery();
        if (results.next()) {
            return results.getDouble(1);
        } else {
            return 0;
        }
    }

    public double getMinY()
            throws SQLException, ClassNotFoundException {
        selectStmt = con.prepareStatement(
                "SELECT min(latitude) "
                + "FROM station "
                + "WHERE type='metro';");
        ResultSet results = selectStmt.executeQuery();
        if (results.next()) {
            return results.getDouble(1);
        } else {
            return 0;
        }
    }

    public double getMaxX()
            throws SQLException, ClassNotFoundException {
        selectStmt = con.prepareStatement(
                "SELECT max(longitude) "
                + "FROM station "
                + "WHERE type='metro';");
        ResultSet results = selectStmt.executeQuery();
        if (results.next()) {
            return results.getDouble(1);
        } else {
            return 0;
        }
    }

    public double getMaxY()
            throws SQLException, ClassNotFoundException {
        selectStmt = con.prepareStatement(
                "SELECT max(latitude) "
                + "FROM station "
                + "WHERE type='metro';");
        ResultSet results = selectStmt.executeQuery();
        if (results.next()) {
            return results.getDouble(1);
        } else {
            return 0;
        }
    }
}
