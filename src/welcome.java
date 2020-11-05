import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class welcome extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Font font1=Font.font("Times", FontWeight.BOLD,
                FontPosture.ITALIC,30);
        Font font2=Font.font("Times", FontWeight.BOLD,
                FontPosture.ITALIC,20);
        Image image = new Image(new FileInputStream("src/name.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(200);
        HBox hBox = new HBox(imageView);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPadding(new Insets(20));

        Label mName = new Label("Yash Kumar");
        Label pName = new Label("Sidharth Bajaj");
        Label genre = new Label("Genre");
        mName.setPadding(new Insets(40,0,0,40));
        pName.setPadding(new Insets(40,40,0,0));

        mName.setFont(font2);
        pName.setFont(font2);
        genre.setFont(font1);

        Button sports = new Button("Sports-Centric");
        Button comedy = new Button("Comedy");
        Button sci = new Button("Sci-fi");
        sports.setPadding(new Insets(20));
        comedy.setPadding(new Insets(20));
        sci.setPadding(new Insets(20));
        comedy.setMinWidth(150);
        sci.setMinWidth(150);
        sports.setMinWidth(150);


        HBox buttons= new HBox();
        buttons.getChildren().addAll(sports,comedy,sci);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(30);
        buttons.setPadding(new Insets(0,0,20,0));

        sci.setStyle("-fx-background-color: #cceb8b;");
        sports.setStyle("-fx-background-color: #cceb8b;");
        comedy.setStyle("-fx-background-color: #cceb8b;");

//        sports.setOnMouseClicked(e ->
//        {
//            MainActivity.mainStage.setScene(new LeaderBoardScene());
//            MainActivity.userName = username.getText();
//            leader.setTextFill(Color.GREEN);
//            player.stop();
//        });

        borderPane.setTop(hBox);
        borderPane.setLeft(mName);
        borderPane.setRight(pName);
        borderPane.setBottom(buttons);
        borderPane.setCenter(genre);
        borderPane.setStyle("-fx-background-color: #97d076;");

        Scene scene = new Scene(borderPane, 700, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Box Office");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
