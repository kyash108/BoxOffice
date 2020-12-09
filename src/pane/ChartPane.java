package pane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.chart.*;
import main.Welcome;
import scene.MainScene;
import tables.ComedyTable;
import tables.SciTable;
import tables.SportsTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
       @author Sidharth Bajaj
       @date 3 Dec
       Coded Chart Pane with adding manual values
       */
public class ChartPane extends VBox {

    public ChartPane()  {
        VBox vBox = new VBox();
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
        backButton.setOnAction(e-> Welcome.stage.setScene(new MainScene()));

        ComedyTable comedyTable = new ComedyTable();
        int comedyMovies = comedyTable.getComedy().size();

        SciTable sciTable = new SciTable();
        int sciMovies = sciTable.getSci().size();

        SportsTable sportsTable = new SportsTable();
        int sportsMovies = sportsTable.getSports().size();

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Sports", sportsMovies),
                        new PieChart.Data("Comedy", comedyMovies),
                        new PieChart.Data("Sci-fi", sciMovies));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Movies");

        vBox.getChildren().add(chart);
        vBox.setAlignment(Pos.CENTER);
        this.getChildren().addAll(backButton,vBox);

        this.setStyle("-fx-background-color: #97d076;");
    }

}