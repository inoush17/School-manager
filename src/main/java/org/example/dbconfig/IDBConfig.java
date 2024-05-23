package org.example.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;

public interface IDBConfig {
    static String host = "localhost";
    static String port = "3306";
    static String username = "root";
    static String password = "";
    static String database = "school_manager";
    static String URL = "jdbc:mysql://"+host+":"+port+"/"+database;
    static Connection getConnection(){
        try{
            DriverManager.getConnection(URL, username, password);
            System.out.println("Connexion à le base de données effectuée");
            return DriverManager.getConnection(URL, username, password);
        } catch (Exception e){
            System.out.println("Connexion à la base de données non aboutie");
            return null;
        }
    }
}
