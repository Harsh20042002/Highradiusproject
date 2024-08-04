package com.highradius.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Harsh@2002";

    public static Connection connect() throws ClassNotFoundException 
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            if(conn!=null)
            {
            	return conn;
            }
            
        } 
        catch (SQLException e) 
        {
            System.out.println("Database connection error ans Conn is NULL");
            e.printStackTrace();
        }
		return null;
    }
}
