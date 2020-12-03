package main;
import javafx.application.Application;
import javafx.stage.Stage;
import scene.loginScene;
import scene.mainScene;

public class welcome extends Application {
     public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;
        primaryStage.setScene(new loginScene());
        primaryStage.setTitle("Box Office");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
