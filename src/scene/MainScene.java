package scene;
import javafx.scene.Scene;
import pane.MainPane;

public class MainScene extends Scene {
   public MainScene(){
       super(new MainPane(),700, 300);
   }
}
