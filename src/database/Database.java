package database;

import java.sql.*;

public class Database {
    public static Database instance = null;
    private Connection connection = null;

    //
    private Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca"+Login.DB_NAME+"?useSSL=false",
                    Login.DB_USER, Login.DB_PASSWORD);
            System.out.println("connection created");

        } catch (Exception e) {
            e.printStackTrace();
        }
        // database
        try {
            createTable(DBConst.TABLE_COMEDY,DBConst.CREATE_TABLE_COMEDY,connection);
            createTable(DBConst.TABLE_SCI,DBConst.CREATE_TABLE_SCIFI,connection);
            createTable(DBConst.TABLE_SPORTS,DBConst.CREATE_TABLE_SPORTS,connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
    public void close(){
        System.out.println("Closing Application");
        try {
            connection.close();
        }catch (SQLException e){
            connection = null;
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createComedyTable;
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null,null,tableName,null);
        if (resultSet.next()){
            System.out.println(tableName+" Table already exists!");
        }else {
            createComedyTable = connection.createStatement();
            createComedyTable.execute(tableQuery);
            System.out.println(" The " + tableName + " table has been inserted");
        }

    }
}

