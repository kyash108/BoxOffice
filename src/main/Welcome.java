package main;
import javafx.application.Application;
import javafx.stage.Stage;
import scene.LoginScene;

public class Welcome extends Application {
    /**
    @author Yash Kumar
    @date Nov 5
    Created the basic design format along with simplifying the project
    utilizing the concept of panes and scenes
     */

     public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;
        primaryStage.setScene(new LoginScene());
        primaryStage.setTitle("Box Office");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // commented here
}
