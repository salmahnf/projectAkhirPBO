/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;

/**
 *
 * @author Salma Hanifa
 */
public class UserModel {
    private final String dbUrl = "jdbc:mysql://localhost/tugasjdbc";
    private final String user = "root";
    private final String pass = "";
    
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String query;
    
    public UserModel() {
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkUser(String uName, String pass){
        query = "SELECT * FROM user WHERE username = \"" + uName + "\"  and password = \"" + pass + "\"" ;
        boolean value = false;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if(rs.next()){
                value = true;
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
    
    public boolean addUser(String uName, String pass){
        if(checkUser(uName, pass)){
            return false;
        }
        query = "INSERT INTO user set username =\"" + uName + "\", password = \"" + pass + "\"";
        boolean value = false;
        try {
            stmt = conn.createStatement();
            if (stmt.executeUpdate(query) > 0) {
                value = true;
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
}
