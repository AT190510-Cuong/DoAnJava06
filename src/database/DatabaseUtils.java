/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class DatabaseUtils {

    public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DB_ASS_java3;user=sa;password=123456;encrypt=true;trustServerCertificate=true";

    public static Connection getDBConnect() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (Exception e) {
            System.out.println("Chua co Driver" + e.toString());
        }
        try {
            conn = DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (SQLException e) {
            System.out.println("Loi connect" + e.toString());
        }
        return null;

    }

}
