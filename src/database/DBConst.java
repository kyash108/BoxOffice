package database;

public class DBConst {


    // SPORTS TABLE
    public static final String TABLE_SPORTS = "sports";
    public static final String SPORTS_COLUMN_ID = "id";
    public static final String SPORTS_COLUMN_TITLE = "title";
    public static final String SPORTS_COLUMN_RDATE = "date";
    public static final String SPORTS_COLUMN_DIRECTOR = "director";
    public static final String SPORTS_COLUMN_BUDGET = "budget";

    // COMEDY TABLE
    public static final String TABLE_COMEDY = "comedy";
    public static final String COMEDY_COLUMN_ID = "id";
    public static final String COMEDY_COLUMN_TITLE = "title";
    public static final String COMEDY_COLUMN_RDATE = "date";
    public static final String COMEDY_COLUMN_DIRECTOR = "director";
    public static final String COMEDY_COLUMN_BUDGET = "budget";

    // ACTION SCI-FI
    public static final String TABLE_SCI = "scifi";
    public static final String SCI_COLUMN_ID = "id";
    public static final String SCI_COLUMN_TITLE = "title";
    public static final String SCI_COLUMN_RDATE = "date";
    public static final String SCI_COLUMN_DIRECTOR = "director";
    public static final String SCI_COLUMN_BUDGET = "budget";


    //CRUD

    // Create table

    public static final String CREATE_TABLE_COMEDY =
            "CREATE TABLE " + TABLE_COMEDY + "(" +
                    COMEDY_COLUMN_ID + " int not null auto_increment, " +
                    COMEDY_COLUMN_TITLE + " varchar(50), "+
                    COMEDY_COLUMN_RDATE + " int(4),"+
                    COMEDY_COLUMN_DIRECTOR + " varchar(70), "+
                    COMEDY_COLUMN_BUDGET + " varchar(40) ,"+
                    "PRIMARY KEY(" +COMEDY_COLUMN_ID +"))";


    public static final String CREATE_TABLE_SPORTS =
            "CREATE TABLE " + TABLE_SPORTS + "(" +
                    SPORTS_COLUMN_ID + " int not null auto_increment, " +
                    SPORTS_COLUMN_TITLE + " varchar(50), "+
                    SPORTS_COLUMN_RDATE + " int(4),"+
                    SPORTS_COLUMN_DIRECTOR + " varchar(70), "+
                    SPORTS_COLUMN_BUDGET + " varchar(40) ,"+
                    "PRIMARY KEY(" +SPORTS_COLUMN_ID +"))";

    public static final String CREATE_TABLE_SCIFI =
            "CREATE TABLE " + TABLE_SCI + "(" +
                    SCI_COLUMN_ID + " int not null auto_increment, " +
                    SCI_COLUMN_TITLE + " varchar(50), "+
                    SCI_COLUMN_RDATE + " int(4),"+
                    SCI_COLUMN_DIRECTOR + " varchar(70), "+
                    SCI_COLUMN_BUDGET + " varchar(40) ,"+
                    "PRIMARY KEY(" +SCI_COLUMN_ID +"))";

}
