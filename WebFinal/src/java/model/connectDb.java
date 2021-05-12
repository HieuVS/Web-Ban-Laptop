/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hieu
 */
public class connectDb {
    public static Connection openConnect() {
        try {
            Connection conn = null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                return null;
            }
            conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=Picture;user=sa;password=123456");
            return conn;
        } catch (SQLException ex) {
            return null;
        } 
    }
}
