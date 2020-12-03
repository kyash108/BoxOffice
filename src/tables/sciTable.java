package tables;
import daos.sciDao;
import database.DBConst;
import database.Database;
import pojo.Sci;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sciTable implements sciDao {

    static Database db = Database.getInstance();
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
                        data.getInt(DBConst.SCI_COLUMN_ID),
                        data.getString(DBConst.SCI_COLUMN_TITLE),
                        data.getString(DBConst.SCI_COLUMN_DIRECTOR),
                        data.getInt(DBConst.SCI_COLUMN_RDATE),
                        data.getInt(DBConst.SCI_COLUMN_BUDGET)));

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
                                data.getInt(DBConst.SCI_COLUMN_RDATE));
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

//    public void insertItem(Sci sci) {
//        String query = "INSERT INTO " + DBConst.TABLE_SCI + "(" +
//                DBConst.SCI_COLUMN_TITLE + "," + DBConst.SCI_COLUMN_DIRECTOR + "," + DBConst.SCI_COLUMN_RDATE+
//                ","+DBConst.SCI_COLUMN_BUDGET+") VALUES ('" +
//                sci.getTitle() + "','" + sci.getDirector() + "','" +
//                sci.getBudget() + "','" + sci.getRdate() +
//                "')";
//    }
//
//    public int getItemCount(Sci sci) {
//        int count = -1;
//        try {
//            PreparedStatement getCount = db.getConnection()
//                    .prepareStatement("SELECT * FROM " + DBConst.TABLE_SCI + " WHERE "
//                                    + DBConst.SCI_COLUMN_TITLE + " = '" + sci + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
//                            ResultSet.CONCUR_UPDATABLE);
//            ResultSet data = getCount.executeQuery();
//            data.last();
//            count = data.getRow();
//        }
//        catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return count;
//    }


}

