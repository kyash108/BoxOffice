package daos;
import pojo.Sports;

import java.util.ArrayList;

/*
@author Yash Kumar
@date 26 nov
Utilised pojo in the panes and tables
*/

public interface sportsDao {
    public ArrayList<Sports> getSports();
    public Sports getSports(String title);
    public void createItem(Sports sports);
    public void deleteItem(int id);
}