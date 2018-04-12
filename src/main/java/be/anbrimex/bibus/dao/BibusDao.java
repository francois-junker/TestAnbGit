/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.anbrimex.bibus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francois
 */
public abstract class BibusDao {

    private static String host = "localhost";
    private static String driverDb = "jdbc:mysql";
    private static String dbSchema = "BibusProjectDB";
    private static String port = "3306";

    private static String user = "root";
    private static String password = "Rs15211521";

    private static Connection con = null;

    private static void initConnection() {
        try {
            String url = driverDb + "://" + host + ":" + port + "/" + dbSchema;
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(BibusDao.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    protected static Connection getConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            initConnection();
        }
        return con;
    }

    public static void setHost(String host) {
        BibusDao.host = host;
    }
}
