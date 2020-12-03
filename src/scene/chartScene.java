package scene;
import javafx.scene.Scene;
import pane.chartPane;

public class chartScene extends Scene {
    public chartScene(){
        super(new chartPane(), 700, 300);
    }
}
