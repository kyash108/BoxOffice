package pane;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.welcome;
import pojo.Comedy;
import pojo.DisplayItem;
import scene.mainScene;
import tables.comedyTable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class comedyPane extends HBox {
    public TableView tableView;
    public comedyPane(){
        VBox vBox = new VBox();


        GridPane gridPane = new GridPane();
//        ItemTable itemTable = new ItemTable();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0,25,25,25));

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

        Label idInput = new Label("Id");
        gridPane.add(idInput,0,1);
        TextField idNumber = new TextField();

//    idNumber.setPrefColumnCount(2);
        idNumber.setStyle("-fx-background-color: #cceb8b;");
        gridPane.add(idNumber,1,1);


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


        insert.setOnAction(e-> {
            Comedy comedy = new Comedy(

                    (inputTitle.getText()),inputDirector.getText(),
                    Integer.parseInt(inputReleaseDate.getText()),Integer.parseInt(inputBudget.getText()));

            comedyTable comedyTable = new comedyTable();
            comedyTable.createItem(comedy);
        });

        insert.setStyle("-fx-background-color: #cceb8b;");
        Button delete = new Button("DELETE");
        delete.setStyle("-fx-background-color: #cceb8b;");


        Button update = new Button("UPDATE");
        update.setStyle("-fx-background-color: #cceb8b;");
        update.setOnAction(e-> update());

        hboxForButton.getChildren().addAll(insert,delete,update);
        hboxForButton.setSpacing(5);
        hboxForButton.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(backButton,gridPane,hboxForButton);


        VBox vBoxTable = new VBox();
        Label tableHead = new Label("Comedy");
        tableHead.setFont(Font.font(27));


        TableView tableView = new TableView();

        TableColumn id = new TableColumn("Id");
        tableView.getColumns().addAll(id);

//    TableColumn Title = new TableColumn("Title");
        TableColumn<DisplayItem, String> column1 =
                new TableColumn<>("Title");
        column1.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getTitle()));
        tableView.getColumns().add(column1);

//    TableColumn ReleaseDate = new TableColumn("Release Date");
        TableColumn<DisplayItem, String> column2 =
                new TableColumn<>("Release Date");
        column2.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getrDate()));
        tableView.getColumns().add(column2);

//    TableColumn Director = new TableColumn("Director");
        TableColumn<DisplayItem, String> column3 =
                new TableColumn<>("director");
        column2.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getDirector()));
        tableView.getColumns().add(column3);


//    TableColumn Budget = new TableColumn("Budget");
        TableColumn<DisplayItem, String> column4 =
                new TableColumn<>("Budget");
        column2.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getBudget()));
        tableView.getColumns().add(column4);
//        tableView.getItems().addAll(comedyTable.getPrettyItems());

        tableView.setMinWidth(400);
        tableView.setMaxHeight(220);
        tableView.setStyle("-fx-background-color: #cceb8b;");


        vBoxTable.getChildren().addAll(tableHead,tableView);
        vBoxTable.setAlignment(Pos.TOP_CENTER);

        this.getChildren().addAll(vBox,vBoxTable);

        this.setStyle("-fx-background-color: #97d076;");
//        delete.setOnAction(e-> {
//            Comedy comedy = new Comedy(
//
//                    (inputTitle.getText()),inputDirector.getText(),
//                    Integer.parseInt(inputReleaseDate.getText()),Integer.parseInt(inputBudget.getText()));
//
//            comedyTable comedyTable = new comedyTable();
//            DisplayItem item = (DisplayItem) tableView.getSelectionModel().getSelectedItem();
//            comedyTable.deleteItem(item.getId());
//            refreshTable();
//        });

    }
    public void refreshTable() {
        comedyTable table = new comedyTable();
        tableView.getItems().clear();
//        tableView.getItems().addAll(table.getPrettyItems());
    }

    public void update(){

    }
}

