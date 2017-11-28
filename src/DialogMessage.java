import javafx.scene.control.Alert;

public class DialogMessage {

    public  static void keyError(){
        Alert alert = new Alert(Alert.AlertType.WARNING);//викликається вікно із попередженням
        alert.setTitle("Попередження!");
        alert.setHeaderText("Відсутній ключ!");
        alert.setContentText("Перевірте правильність введення." + '\n'+ "Поле ключа є пустим.");
        alert.showAndWait();
    }

    public  static void successfullCript(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Операція пройшла успішно!");
        alert.setHeaderText(null);
        alert.setContentText("Ваш текст було спішно зашифровано та запсиано в файл.");
        alert.showAndWait();
    }

    public  static void fileError(){
        Alert alert = new Alert(Alert.AlertType.WARNING);//викликається вікно із попередженням
        alert.setTitle("Попередження!");
        alert.setHeaderText("Відсутній файл!");
        alert.setContentText("Перевірте правильність введення." + '\n'+ "Файл не вибрано.");
        alert.showAndWait();
    }

    public  static void fileRecordError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);//викликається вікно із попередженням
        alert.setTitle("Помилка!");
        alert.setHeaderText("Невдача!");
        alert.setContentText("Запис файлу не вдався. Спробуйте знову.");
        alert.showAndWait();
    }


    public  static void fileReadrdError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);//викликається вікно із попередженням
        alert.setTitle("Помилка!");
        alert.setHeaderText("Невдача!");
        alert.setContentText("Читання файлу не вдалося. Спробуйте знову.");
        alert.showAndWait();
    }
}
