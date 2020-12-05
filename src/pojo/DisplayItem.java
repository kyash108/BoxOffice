package pojo;

/*
@author Sidharth Bajaj
@date 26 nov
Utilised pojo in the panes and tables
*/

public class DisplayItem {
    private String id;
    private String title;
    private String director;
    private String rDate;
    private String budget;

    public DisplayItem(String id, String title, String director, String rDate, String budget) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.rDate = rDate;
        this.budget = budget;
    }



    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}
