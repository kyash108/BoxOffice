package tables;
import daos.sciDao;
import database.DBConst;
import database.Database;
import pojo.Comedy;
import pojo.Sci;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sciTable implements sciDao {

    Database db = Database.getInstance();
    ArrayList<Sci> scis;


    public ArrayList<Sci> getSci() {
        String query = "SELECT * FROM "+ DBConst.TABLE_SCI;
        scis = new ArrayList<>();
        try {
            Statement getScis =
                    db.getConnection().createStatement();
            ResultSet data = getScis.executeQuery(query);

            while (data.next()){
                scis.add(new Sci(
//                        data.getInt(DBConst.COMEDY_COLUMN_ID),
                        data.getString(DBConst.SCI_COLUMN_TITLE),
                        data.getString(DBConst.SCI_COLUMN_DIRECTOR),
                        data.getString(DBConst.SCI_COLUMN_RDATE),
                        data.getString(DBConst.SCI_COLUMN_BUDGET)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scis;
    }

    @Override
    public Sci getSci(int id) {
        return null;
    }

    public Comedy getComedy(int id) {
        String query = "SELECT * FROM "+ DBConst.SCI_COLUMN_ID+ " WHERE " + DBConst.SCI_COLUMN_ID+ " = " + id;

        try{
            Statement getSci =
                    db.getConnection().createStatement();
            ResultSet data = getSci.executeQuery(query);
            if(data.next()){
                Comedy scis =
                        new Comedy(
//                                data.getInt(DBConst.COMEDY_COLUMN_ID),
                                data.getString(DBConst.SCI_COLUMN_TITLE),
                                data.getString(DBConst.SCI_COLUMN_DIRECTOR),
                                data.getString(DBConst.SCI_COLUMN_BUDGET),
                                data.getString(DBConst.SCI_COLUMN_RDATE));
                return scis;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateItem(Sci sci) {
        String query = "UPDATE " + DBConst.TABLE_SCI + " SET " +
                DBConst.SCI_COLUMN_ID + " " + sci.getId() +  "," +
                DBConst.SCI_COLUMN_TITLE + " " + sci.getTitle() +  "," +
                DBConst.SCI_COLUMN_DIRECTOR + " " + sci.getDirector() + "," +
                DBConst.SCI_COLUMN_RDATE + " " + sci.getRdate() +
                DBConst.SCI_COLUMN_BUDGET + " " + sci.getBudget() +
                " WHERE " + DBConst.SCI_COLUMN_ID + " = " + sci.getId();
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

    public void insertItem(Sci sci) {
        String query = "INSERT INTO " + DBConst.TABLE_SCI + "(" +
                DBConst.SCI_COLUMN_TITLE + "," + DBConst.SCI_COLUMN_DIRECTOR + "," + DBConst.SCI_COLUMN_RDATE+
                ","+DBConst.SCI_COLUMN_BUDGET+") VALUES ('" +
                sci.getTitle() + "','" + sci.getDirector() + "','" +
                sci.getBudget() + "','" + sci.getRdate() +
                "')";
    }

    public int getItemCount(Sci sci) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT * FROM " + DBConst.TABLE_SCI + " WHERE "
                                    + DBConst.SCI_COLUMN_TITLE + " = '" + sci + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
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

