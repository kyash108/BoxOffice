package pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import main.welcome;
import scene.loginScene;
import scene.mainScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
       @author Yash Kumar
       @date 3 Dec
       Coded Login page with taking user inputs and then proceeding with actual program
       and matching the needed inputs.
       */
public class loginPane extends BorderPane {
    public loginPane(){
        Image image = null;
        try {
            image = new Image(new FileInputStream("src/name.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(200);
        HBox hBox = new HBox(imageView);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPadding(new Insets(20));


        Label labelUsername = new Label("Username");
        TextField username = new TextField();
        username.setStyle("-fx-background-color: #cceb8b;");
        labelUsername.setPadding(new Insets(20));

        Label labelPassword = new Label("Password");
        PasswordField password = new PasswordField();
        password.setStyle("-fx-background-color: #cceb8b;");
        labelPassword.setPadding(new Insets(20));

        Button login = new Button("Login");
        login.setPadding(new Insets(20));
        login.setMinWidth(80);
        login.setMaxHeight(35);

        login.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(username.getText().equals("username") && password.getText().equals("password")){
                    welcome.stage.setScene(new mainScene());
                }else{
                welcome.stage.setScene(new loginScene());
            }
            }});
        login.setStyle("-fx-background-color: #cceb8b;");

        HBox usernameH = new HBox(labelUsername,username,labelPassword,password);
        usernameH.setAlignment(Pos.CENTER);
        HBox button = new HBox(login);
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setMaxHeight(25);
        button.setPadding(new Insets(0,0,20,0));

        this.setTop(hBox);
        this.setCenter(usernameH);
        this.setBottom(button);

        this.setStyle("-fx-background-color: #97d076;");

    }
}
