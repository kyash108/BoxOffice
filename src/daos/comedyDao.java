package daos;

import pojo.Comedy;

import java.util.ArrayList;

public interface comedyDao{
    public ArrayList<Comedy> getComedy();
    public Comedy getComedy(int id);
    public void updateItem(Comedy comedy);
    public void deleteItem(int id);

    void createItem(Comedy comedy);

    //    public void createItem(Comedy comedy);
    public void insertItem(Comedy comedy);
}
