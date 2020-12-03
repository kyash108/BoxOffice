package daos;
import pojo.Sports;

import java.util.ArrayList;
public interface sportsDao {
    public ArrayList<Sports> getSports();
    public Sports getSports(String title);
    public void createItem(Sports sports);
    public void updateItem(Sports sports);
    public void deleteItem(int id);
}