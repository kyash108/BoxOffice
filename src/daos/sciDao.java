package daos;
import pojo.Sci;

import java.util.ArrayList;

public interface sciDao{
    public ArrayList<Sci> getSci();
    public Sci getSci(int id);
    public void updateItem(Sci sci);
    public void deleteItem(int id);

    void createItem(Sci sci);

    //    public void createItem(Sci sci);
    public void insertItem(Sci sci);
}
