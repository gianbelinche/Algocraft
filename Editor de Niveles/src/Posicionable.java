import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Posicionable {
    Image sprite;

    public Posicionable(){
        sprite = new Image("file:img/iso.png");
    }

    public Image imagen(){
        return sprite;
    }

}
