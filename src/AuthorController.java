import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class AuthorController {

    @FXML
    public ImageView logoFIT;


    public void initialize() {
        File file = new File("img/fit.png");//Отримуємо файл по шляху
        Image image = new Image(file.toURI().toString());
        logoFIT.setImage(image);

    }
}
