/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import test.testing;

/**
 *
 * @author yajnesh
 */
public class dbConnect {

    /*
     * String dbUrl =
     * "jdbc:mysql://matrixos.instantfreesite.com:3306/yajnesh_test_db"; String
     * dbUser="yajnesh_yajnesh"; String dbPass="hello";
     *
     */
    String dbUrl = "jdbc:mysql://localhost:3306/pace_db";
    String dbUser = "root";
    String dbPass = "";
    String dbClass = "com.mysql.jdbc.Driver";
    static Connection con = null;
    public static Statement stmt = null;

    public dbConnect() {
        try {
            Class.forName(dbClass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public static Connection getCon() {
        return con;
    }
}
