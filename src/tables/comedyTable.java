package tables;

import daos.comedyDao;
import database.DBConst;
import database.Database;
import pojo.Comedy;
import pojo.DisplayItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
@author Sidharth Bajaj
@date 26 Nov
created tables and utilised crud statement in them
*/

public class comedyTable implements comedyDao {

    static Database db = Database.getInstance();
    ArrayList<Comedy> comedys;

    public static void deleteItem(String id) {
        String query  = "DELETE FROM " + DBConst.TABLE_COMEDY + " WHERE " +
                DBConst.COMEDY_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted record");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
    @author Sidharth Bajaj
    @date 26 nov
    getting tables from the database after the table is created
    */
    @Override
    public ArrayList<Comedy> getComedy() {
        String query = "SELECT * FROM "+ DBConst.TABLE_COMEDY;
        comedys = new ArrayList<>();
        try {
            Statement getComedys =
                    db.getConnection().createStatement();
            ResultSet data = getComedys.executeQuery(query);

            while (data.next()){
                comedys.add(
                        new Comedy(
                                data.getInt(DBConst.COMEDY_COLUMN_ID),
                                data.getString(DBConst.COMEDY_COLUMN_TITLE),
                                data.getString(DBConst.COMEDY_COLUMN_DIRECTOR),
                                data.getInt(DBConst.COMEDY_COLUMN_RDATE),
                                data.getString(DBConst.COMEDY_COLUMN_BUDGET)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comedys;
    }

    @Override
    public Comedy getComedy(String title) {
        String query = "SELECT * FROM "+ DBConst.COMEDY_COLUMN_TITLE+ " WHERE " + DBConst.COMEDY_COLUMN_TITLE+ " = " + title;

        try{
            Statement getComedy =
                    db.getConnection().createStatement();
            ResultSet data = getComedy.executeQuery(query);
            if(data.next()){
                Comedy comedys =
                        new Comedy(
                                data.getInt(DBConst.COMEDY_COLUMN_ID),
                                data.getString(DBConst.COMEDY_COLUMN_TITLE),
                                data.getString(DBConst.COMEDY_COLUMN_DIRECTOR),
                                data.getInt(DBConst.COMEDY_COLUMN_BUDGET),
                                data.getString(DBConst.COMEDY_COLUMN_RDATE));
                return comedys;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
    @author Sidharth Bajaj
    @date 26 nov
    Created delete statement so that the selected/clicked record gets deleted.
    */
    @Override
    public void deleteItem(int id) {
        String query  = "DELETE FROM " + DBConst.TABLE_COMEDY + " WHERE " +
                DBConst.COMEDY_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted record");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
        @author Sidharth Bajaj
        @date 26 nov
        Created delete statement so that the selected/clicked record gets deleted.
        */
    @Override
    public void createItem(Comedy comedy) {
        String query = "INSERT INTO " + DBConst.TABLE_COMEDY +
                "(" + DBConst.COMEDY_COLUMN_TITLE + ", " +
                DBConst.COMEDY_COLUMN_DIRECTOR + "," +
                DBConst.COMEDY_COLUMN_BUDGET + "," +
                DBConst.COMEDY_COLUMN_RDATE + ") VALUES ('" +
                comedy.getTitle() + "','" + comedy.getDirector() + "','" +
                comedy.getBudget() + "','" + comedy.getRdate() +
                "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
    @author Sidharth Bajaj
    @date 2 Dec
    Created delete statement so that the selected/clicked record gets deleted.
    */

    public static ArrayList<DisplayItem> getPrettyItems(){
        ArrayList<DisplayItem> items = new ArrayList<DisplayItem>();
        String query = "SELECT * from comedy";

        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                items.add(new DisplayItem(data.getString("id"),
                        data.getString("title"),
                        data.getString("director"),
                        data.getString("date"),
                        data.getString("budget")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return items;
    }

}

