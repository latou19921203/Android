package com.example.a61555.dbconnectdemo;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 61555 on 2017/12/19.
 */

public class DBConnection {

    private static final String IP = "192.168.1.100:3306";
    private static final String DATABASENAME = "test";
    private static final String URL = "jdbc:mysql://"+IP+"/"+DATABASENAME;
    private static final String USERNAME = "root";
    private static final String PWD = "root";
    private static Connection conn = null;

    public static Connection getInstance(){
        if (conn == null) {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Log.i("[Connection]", URL);
                conn = DriverManager.getConnection(URL, USERNAME, PWD);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void disconnect() {
        if (conn != null) {
            try{
                conn.close();
            } catch (SQLException e) {
                System.console().printf(e.getMessage());
            }
        }
    }
}
