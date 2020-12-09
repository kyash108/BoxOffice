package scene;
import javafx.scene.Scene;
import pane.ChartPane;

public class ChartScene extends Scene {
    public ChartScene(){
        super(new ChartPane(), 700, 300);
    }
}
