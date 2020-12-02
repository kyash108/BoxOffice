package pojo;

public class Comedy {
    private int id;
    private String title;
    private String director;
    private int Rdate;
    private int Budget;

    public Comedy(int id, String title, String director, int rdate, int budget) {
        this.id = id;
        this.title = title;
        this.director = director;
        Rdate = rdate;
        Budget = budget;
    }

    public Comedy(String title, String director, int rdate, int budget) {
        this.title = title;
        this.director = director;
        Rdate = rdate;
        Budget = budget;
    }

    public Comedy(){

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

    public int getRdate() {
        return Rdate;
    }

    public void setRdate(int rdate) {
        Rdate = rdate;
    }

    public int getBudget() {
        return Budget;
    }


    public void setBudget(int budget) {
        Budget = budget;

    }

    @Override
    public String toString() {
        return getTitle()+ " ";
    }
}

