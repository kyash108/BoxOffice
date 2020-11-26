package tables;

import daos.comedyDao;
import database.DBConst;
import database.Database;
import pojo.Comedy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class comedyTable implements comedyDao {

    Database db = Database.getInstance();
    ArrayList<Comedy> comedys;


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
//                            data.getInt(DBConst.COMEDY_COLUMN_ID),
                            data.getString(DBConst.COMEDY_COLUMN_TITLE),
                            data.getString(DBConst.COMEDY_COLUMN_DIRECTOR),
                            data.getString(DBConst.COMEDY_COLUMN_RDATE),
                            data.getString(DBConst.COMEDY_COLUMN_BUDGET)));

        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comedys;
    }

    @Override
    public Comedy getComedy(int id) {
        String query = "SELECT * FROM "+ DBConst.COMEDY_COLUMN_ID+ " WHERE " + DBConst.COMEDY_COLUMN_ID+ " = " + id;

        try{
            Statement getComedy =
                    db.getConnection().createStatement();
            ResultSet data = getComedy.executeQuery(query);
            if(data.next()){
                Comedy comedys =
                        new Comedy(
//                                data.getInt(DBConst.COMEDY_COLUMN_ID),
                                data.getString(DBConst.COMEDY_COLUMN_TITLE),
                                data.getString(DBConst.COMEDY_COLUMN_DIRECTOR),
                                data.getString(DBConst.COMEDY_COLUMN_BUDGET),
                                data.getString(DBConst.COMEDY_COLUMN_RDATE));
                return comedys;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateItem(Comedy comedy) {
        String query = "UPDATE " + DBConst.TABLE_COMEDY + " SET " +
                DBConst.COMEDY_COLUMN_ID + " " + comedy.getId() +  "," +
                DBConst.COMEDY_COLUMN_TITLE + " " + comedy.getTitle() +  "," +
                DBConst.COMEDY_COLUMN_DIRECTOR + " " + comedy.getDirector() + "," +
                DBConst.COMEDY_COLUMN_RDATE + " " + comedy.getRdate() +
                DBConst.COMEDY_COLUMN_BUDGET + " " + comedy.getBudget() +
                " WHERE " + DBConst.COMEDY_COLUMN_ID + " = " + comedy.getId();
        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeQuery(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

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

    @Override
    public void insertItem(Comedy comedy) {
        String query = "INSERT INTO " + DBConst.TABLE_COMEDY + "(" +
                        DBConst.COMEDY_COLUMN_TITLE + "," + DBConst.COMEDY_COLUMN_DIRECTOR + "," + DBConst.COMEDY_COLUMN_RDATE+
                        ","+DBConst.COMEDY_COLUMN_BUDGET+") VALUES ('" +
                comedy.getTitle() + "','" + comedy.getDirector() + "','" +
                comedy.getBudget() + "','" + comedy.getRdate() +
                "')";
    }

    public int getItemCount(Comedy comedy) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT * FROM " + DBConst.TABLE_COMEDY + " WHERE "
                                    + DBConst.COMEDY_COLUMN_TITLE + " = '" + comedy + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.last();
            count = data.getRow();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


}

