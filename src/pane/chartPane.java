package pane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.chart.*;
import main.welcome;
import scene.mainScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class chartPane extends VBox {
    public chartPane(){
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
        backButton.setOnAction(e-> welcome.stage.setScene(new mainScene()));

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Sports", 5),
                        new PieChart.Data("Comedy", 4),
                        new PieChart.Data("Sci-fi", 7));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Movies");

        vBox.getChildren().add(chart);
        vBox.setAlignment(Pos.CENTER);
        this.getChildren().addAll(backButton,vBox);

        this.setStyle("-fx-background-color: #97d076;");
    }
}