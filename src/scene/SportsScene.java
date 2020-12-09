package scene;
import javafx.scene.Scene;
import pane.SportsPane;

public class SportsScene extends Scene {
    public SportsScene(){
        super(new SportsPane(),700, 300);
    }
}
