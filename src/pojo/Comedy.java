package pojo;

public class Comedy {
    private int id;
    private String title;
    private String director;
    private String Rdate;
    private String Budget;

    public Comedy(int id, String title, String director, String rdate, String budget) {
        this.id = id;
        this.title = title;
        this.director = director;
        Rdate = rdate;
        Budget = budget;
    }

    public Comedy(int id) {
        this.id = id;
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

    public String getRdate() {
        return Rdate;
    }

    public void setRdate(String rdate) {
        Rdate = rdate;
    }

    public String getBudget() {
        return Budget;
    }

    public void setBudget(String budget) {
        Budget = budget;
    }
}
