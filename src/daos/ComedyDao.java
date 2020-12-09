package daos;
import pojo.Comedy;
import java.util.ArrayList;

/*
@author Sidharth Bajaj
@date 26 nov
Utilised pojo in the panes and tables
*/
public interface ComedyDao {
    public ArrayList<Comedy> getComedy();
    public Comedy getComedy(String title);
    public void createItem(Comedy comedy);
    public void deleteItem(int id);
}