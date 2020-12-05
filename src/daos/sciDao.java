package daos;
import pojo.Sci;
import java.util.ArrayList;

/*
@author Yash Kumar
@date 26 nov
Utilised pojo in the panes and tables
*/

public interface sciDao{
    public ArrayList<Sci> getSci();
    public Sci getSci(String title);
    public void createItem(Sci sci);
    public void deleteItem(int id);
}
