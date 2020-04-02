import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double toX;
    private double toY;
    private Stage stag;

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/index.fxml"));
        this.stag=stage;
        Scene scene = new Scene(root);

        scene.setOnMousePressed(this::handleMousePressed);
        scene.setOnMouseDragged(this::handleMouseDragged);

        stag.setScene(scene);
        stag.initStyle(StageStyle.UNDECORATED);
        stag.show();
    }

    protected void handleMousePressed(MouseEvent e) {
        this.toX = e.getScreenX() - stag.getX();
        this.toY = e.getScreenY() - stag.getY();
    }

    protected void handleMouseDragged(MouseEvent e) {
        stag.setX(e.getScreenX() - this.toX);
        stag.setY(e.getScreenY() - this.toY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
