package pane;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.welcome;
import pojo.Sports;
import pojo.DisplayItem;
import scene.chartScene;
import scene.mainScene;
import scene.sportsScene;
import tables.sportsTable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class sportsPane extends HBox {

    /**
    @author Yash Kumar
    @date Nov 5
    Created Sports table page in javafx displaying the insert bars and tableview which is
    getting data from the database and displaying it to the user.
    */

    public sportsPane(){
        /**
        @author Yash Kumar
        @date Nov 11
        Created Vbox with gridpane.
        Buttons and textfields are inserted in the gridpane.
        On the right side - places tableview which is getting table.
        */

        VBox vBox = new VBox();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0,25,25,25));

        /**
        @author Yash Kumar
        @date 11 nov
        Inserted image for utilizing the back button and also created the back button in photoshop.
        */

        Image image = null;
        try {
            image = new Image(new FileInputStream("src/images/backArrow.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView backImageView = new ImageView(image);
        backImageView.setFitWidth(30);
        backImageView.setFitHeight(30);

        Button backButton = new Button("",backImageView);
        backButton.setStyle("-fx-background-color: #97d076;");
        backButton.setMaxHeight(30);
        backButton.setMaxWidth(30);
        backButton.setOnAction(e-> welcome.stage.setScene(new mainScene()));

        /**
        @author Yash Kumar
        @date 11 nov
        Labels for textfields for getting inputs from the user
        */

        /**
        @author Sidharth Bajaj
        @date 12 nov
        Inserted image for utilizing the back button and also created the back button in photoshop.
        Made png file as an image to shift to previous panes
        */


        Label labelInput = new Label("Title");
        gridPane.add(labelInput,0,2);
        TextField inputTitle = new TextField();
        inputTitle.setStyle("-fx-background-color: #cceb8b;");
        gridPane.add(inputTitle,1,2);


        Label Date = new Label("Year");
        gridPane.add(Date,0,3);
        TextField inputReleaseDate = new TextField();
        inputReleaseDate.toString().contains("2020/10/10");
        inputReleaseDate.setStyle("-fx-background-color: #cceb8b;");
        gridPane.add(inputReleaseDate,1,3);


        Label director = new Label("Director");
        gridPane.add(director,0,4);
        TextField inputDirector = new TextField();
        inputDirector.setStyle("-fx-background-color: #cceb8b;");
        gridPane.add(inputDirector,1,4);

        Label budget = new Label("Budget");
        gridPane.add(budget,0,5);
        TextField inputBudget = new TextField();
        inputBudget.setStyle("-fx-background-color: #cceb8b;");
        gridPane.add(inputBudget,1,5);

        HBox hboxForButton = new HBox();
        Button insert = new Button("INSERT");

        /**
         @author Yash Kumar
         @date 11 nov
         created insert button for function
        */

        /**
        @author Yash Kumar
        @date 2 dec
        insert button inserting data to database with proper datatypes
        that are matching with table structure.
         */

        insert.setOnAction(e-> {
            Sports sport = new Sports(

                    (inputTitle.getText()),inputDirector.getText(),
                    Integer.parseInt(inputReleaseDate.getText()),inputBudget.getText());

            sportsTable sportsTable = new sportsTable();
            sportsTable.createItem(sport);
            welcome.stage.setScene(new sportsScene());
        });



        Button chart = new Button("CHART");
        chart.setStyle("-fx-background-color: #cceb8b;");
        chart.setOnAction(e-> welcome.stage.setScene(new chartScene()));


        hboxForButton.setSpacing(5);
        hboxForButton.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(backButton,gridPane,hboxForButton);


        VBox vBoxTable = new VBox();
        Label tableHead = new Label("Sports");
        tableHead.setFont(Font.font(27));

        /**
        @author Yash Kumar
        @date 11 nov
        created basic table

        @author Yash Kumar
        @date 2 dec
        changed the tableView and made code for the data to be viewed
        from database
         */

        TableView tableView = new TableView();

        TableColumn<DisplayItem, String> column1 =
                new TableColumn<>("Id");
        column1.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getId()));
        column1.setStyle("-fx-background-color: #cceb8b;");
        column1.setMinWidth(5);
        tableView.getColumns().add(column1);

        TableColumn<DisplayItem, String> column2 =
                new TableColumn<>("Title");
        column2.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getTitle()));
        column2.setStyle("-fx-background-color: #cceb8b;");
        tableView.getColumns().add(column2);

        TableColumn<DisplayItem, String> column3 =
                new TableColumn<>("Year");
        column3.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getrDate()));
        column3.setStyle("-fx-background-color: #cceb8b;");
        tableView.getColumns().add(column3);

        TableColumn<DisplayItem, String> column4 =
                new TableColumn<>("Director");
        column4.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getDirector()));
        column4.setStyle("-fx-background-color: #cceb8b;");
        tableView.getColumns().add(column4);


        TableColumn<DisplayItem, String> column5 =
                new TableColumn<>("Budget");
        column5.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getBudget()));
        column5.setStyle("-fx-background-color: #cceb8b;");
        tableView.getColumns().add(column5);
        tableView.getItems().addAll(sportsTable.getPrettyItems());

        tableView.setMaxHeight(220);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setMaxWidth(Region.USE_COMPUTED_SIZE);

        vBoxTable.getChildren().addAll(tableHead,tableView);
        vBoxTable.setAlignment(Pos.TOP_CENTER);

        insert.setStyle("-fx-background-color: #cceb8b;");

        /**
        @author Yash Kumar
        @date 11 nov
        Created basic delete button to be displayed on table
         */

        /**
        @author Sidharth Bajaj
        @date dec 2
        implemented delete command to table and its getting data from table
        on click and then deleting the data once pressed.
         */


        Button delete = new Button("DELETE");
        delete.setStyle("-fx-background-color: #cceb8b;");

        delete.setOnAction(e->{
            DisplayItem sports = (DisplayItem) tableView.getSelectionModel().getSelectedItem();
            sportsTable.deleteItem(sports.getId());
            welcome.stage.setScene(new sportsScene());

        });
        hboxForButton.getChildren().addAll(insert,delete,chart);

        this.getChildren().addAll(vBox,vBoxTable);
        this.setStyle("-fx-background-color: #97d076;");
    }
}

