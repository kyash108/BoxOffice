package scene;
import javafx.scene.Scene;
import pane.SciPane;

public class SciScene extends Scene {
    public SciScene(){
        super(new SciPane(),700, 300);
    }
}
