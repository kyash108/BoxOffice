package tables;
import daos.sciDao;
import database.DBConst;
import database.Database;
import pojo.DisplayItem;
import pojo.Sci;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sciTable implements sciDao {

    static Database db = Database.getInstance();
    ArrayList<Sci> scis;

    public static void deleteItem(String id) {
        String query  = "DELETE FROM " + DBConst.TABLE_SCI + " WHERE " +
                DBConst.SCI_COLUMN_ID + " = " + id;
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


    public ArrayList<Sci> getSci() {
        String query = "SELECT * FROM "+ DBConst.TABLE_SCI;
        scis = new ArrayList<>();
        try {
            Statement getScis =
                    db.getConnection().createStatement();
            ResultSet data = getScis.executeQuery(query);

            while (data.next()){
                scis.add(new Sci(
                        data.getInt(DBConst.SCI_COLUMN_ID),
                        data.getString(DBConst.SCI_COLUMN_TITLE),
                        data.getString(DBConst.SCI_COLUMN_DIRECTOR),
                        data.getInt(DBConst.SCI_COLUMN_RDATE),
                        data.getString(DBConst.SCI_COLUMN_BUDGET)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scis;
    }

    public Sci getSci(int id) {
        String query = "SELECT * FROM "+ DBConst.SCI_COLUMN_ID+ " WHERE " + DBConst.SCI_COLUMN_ID+ " = " + id;

        try{
            Statement getSci =
                    db.getConnection().createStatement();
            ResultSet data = getSci.executeQuery(query);
            if(data.next()){
                Sci scis =
                        new Sci(
                                data.getInt(DBConst.SCI_COLUMN_ID),
                                data.getString(DBConst.SCI_COLUMN_TITLE),
                                data.getString(DBConst.SCI_COLUMN_DIRECTOR),
                                data.getInt(DBConst.SCI_COLUMN_BUDGET),
                                data.getString(DBConst.SCI_COLUMN_RDATE));
                return scis;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Sci getSci(String title) {
        return null;
    }
        /*
        @author Sidharth Bajaj
        @date 26 nov
        Created delete statement so that the selected/clicked record gets deleted.
        */

    @Override
    public void deleteItem(int id) {
        String query  = "DELETE FROM " + DBConst.TABLE_SCI + " WHERE " +
                DBConst.SCI_COLUMN_ID + " = " + id;
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
    Created create statement so that the table is created.
    */

    public void createItem(Sci sci) {
        String query = "INSERT INTO " + DBConst.TABLE_SCI +
                "(" + DBConst.SCI_COLUMN_TITLE + ", " +
                DBConst.SCI_COLUMN_DIRECTOR + "," +
                DBConst.SCI_COLUMN_BUDGET + "," +
                DBConst.SCI_COLUMN_RDATE + ") VALUES ('" +
                sci.getTitle() + "','" + sci.getDirector() + "','" +
                sci.getBudget() + "','" + sci.getRdate() +
                "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
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
        String query = "SELECT * from scifi";

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

