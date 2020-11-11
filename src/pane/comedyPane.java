package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class comedyPane extends HBox {
    public comedyPane(){
    VBox vBox = new VBox();

    GridPane gridPane = new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

    Label idInput = new Label("Id");
        gridPane.add(idInput,0,1);
    TextField idNumber = new TextField();
        idNumber.setStyle("-fx-background-color: #cceb8b;");
        gridPane.add(idNumber,1,1);


    Label labelInput = new Label("Title");
        gridPane.add(labelInput,0,2);
    TextField inputTitle = new TextField();
        inputTitle.setStyle("-fx-background-color: #cceb8b;");
        gridPane.add(inputTitle,1,2);


    Label Date = new Label("Date");
        gridPane.add(Date,0,3);
    TextField inputReleaseDate = new TextField();
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
        insert.setOnAction(e-> insert());
        insert.setStyle("-fx-background-color: #cceb8b;");
    Button delete = new Button("DELETE");
        delete.setStyle("-fx-background-color: #cceb8b;");
        delete.setOnAction(e-> delete());
    Button update = new Button("UPDATE");
        update.setStyle("-fx-background-color: #cceb8b;");
        update.setOnAction(e-> update());

        hboxForButton.getChildren().addAll(insert,delete,update);
        hboxForButton.setSpacing(5);
        hboxForButton.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(gridPane,hboxForButton);


    VBox vBoxTable = new VBox();
    Label tableHead = new Label("Comedy");
        tableHead.setFont(Font.font(27));



    TableView<String> tableView = new TableView<String>();

    TableColumn id = new TableColumn("Id");
    TableColumn Title = new TableColumn("Title");
    TableColumn ReleaseDate = new TableColumn("Release Date");
    TableColumn Director = new TableColumn("Director");
    TableColumn Budget = new TableColumn("Budget");
        tableView.setMinWidth(400);
        tableView.setMaxHeight(220);
        tableView.setStyle("-fx-background-color: #cceb8b;");
        tableView.getColumns().addAll(id,Title,ReleaseDate,Director,Budget);

        vBoxTable.getChildren().addAll(tableHead,tableView);
        vBoxTable.setAlignment(Pos.TOP_CENTER);

        this.getChildren().addAll(vBox,vBoxTable);

        this.setStyle("-fx-background-color: #97d076;");
}

    public void update(){

    }
    public void delete(){

    }
    public void insert(){

    }
}
