package tables;
import daos.sportsDao;
import database.DBConst;
import database.Database;
import pojo.DisplayItem;
import pojo.Sports;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sportsTable implements sportsDao {

    static Database db = Database.getInstance();
    ArrayList<Sports> sport;


    @Override
    public ArrayList<Sports> getSports() {
        String query = "SELECT * FROM "+ DBConst.TABLE_SPORTS;
        sport = new ArrayList<>();
        try {
            Statement getsport =
                    db.getConnection().createStatement();
            ResultSet data = getsport.executeQuery(query);

            while (data.next()){
                sport.add(
                        new Sports(
                                data.getInt(DBConst.SPORTS_COLUMN_ID),
                                data.getString(DBConst.SPORTS_COLUMN_TITLE),
                                data.getString(DBConst.SPORTS_COLUMN_DIRECTOR),
                                data.getInt(DBConst.SPORTS_COLUMN_RDATE),
                                data.getString(DBConst.SPORTS_COLUMN_BUDGET)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sport;
    }

    @Override
    public Sports getSports(String title) {
        String query = "SELECT * FROM "+ DBConst.SPORTS_COLUMN_TITLE+ " WHERE " + DBConst.SPORTS_COLUMN_TITLE+ " = " + title;

        try{
            Statement getSports =
                    db.getConnection().createStatement();
            ResultSet data = getSports.executeQuery(query);
            if(data.next()){
                Sports sport =
                        new Sports(
                                data.getInt(DBConst.SPORTS_COLUMN_ID),
                                data.getString(DBConst.SPORTS_COLUMN_TITLE),
                                data.getString(DBConst.SPORTS_COLUMN_DIRECTOR),
                                data.getInt(DBConst.SPORTS_COLUMN_BUDGET),
                                data.getString(DBConst.SPORTS_COLUMN_RDATE));
                return sport;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteItem(int id) {
        String query  = "DELETE FROM " + DBConst.TABLE_SPORTS + " WHERE " +
                DBConst.SPORTS_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted record");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void createItem(Sports sports) {
        String query = "INSERT INTO " + DBConst.TABLE_SPORTS +
                "(" + DBConst.SPORTS_COLUMN_TITLE + ", " +
                DBConst.SPORTS_COLUMN_DIRECTOR + "," +
                DBConst.SPORTS_COLUMN_BUDGET + "," +
                DBConst.SPORTS_COLUMN_RDATE + ") VALUES ('" +
                sports.getTitle() + "','" + sports.getDirector() + "','" +
                sports.getBudget() + "','" + sports.getRdate() +
                "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ArrayList<DisplayItem> getPrettyItems(){
        ArrayList<DisplayItem> items = new ArrayList<DisplayItem>();
        String query = "SELECT * from sports";

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

