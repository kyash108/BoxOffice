package pojo;

public class DisplayItem {
    private int id;
    private String title;
    private String director;
    private String rDate;
    private String budget;

    public DisplayItem(int id, String title, String director, String rDate, String budget) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.rDate = rDate;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
