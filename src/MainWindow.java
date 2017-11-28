import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainWindow extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));//Завантажуємо фрейм в пам'ять
        primaryStage.setTitle("XOR");//задаємо назву вінка
        primaryStage.setScene(new Scene(root, 600, 400));//сцена відкриється в заданому розмірі
        primaryStage.setMinHeight(400);// задаються мінімальні параметри вікна
        primaryStage.setMinWidth(600);
        primaryStage.show();// відображення вікна

    }

    public static void main(String[] args) {
        launch(args);//запуск основної програми
    }
}

