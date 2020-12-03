package daos;
import pojo.Sci;
import java.util.ArrayList;
public interface sciDao{
    public ArrayList<Sci> getSci();
    public Sci getSci(String title);
    public void createItem(Sci sci);
    public void deleteItem(int id);
}
