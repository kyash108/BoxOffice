package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Database instance = null;

    private Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca"+Login.DB_NAME+"?useSSL=false",
                    Login.DB_USER, Login.DB_PASSWORD);
            System.out.println("connection created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }
}

