import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class MainWindowController {
    @FXML
    public MenuItem menu_author;
    @FXML
    private TextField textField_filePath;
    @FXML
    private TextArea textArea_encrypt;
    @FXML
    private TextField textFieldKey_encrypt;
    @FXML
    private TextField textFieldKey_dencrypt;
    @FXML
    private TextArea textArea_dencrypt;

    private String pathOfFile;

    /*
    Метод виконуэться одразу після завантаження файлу fxml
     */
    public void initialize() {

        textField_filePath.setEditable(false); //Забороняємо редагувати текстове поле з вибраним файлом
        textArea_dencrypt.setWrapText(true);// Вмикаємо перенос тексту в текстових TextArea
        textArea_encrypt.setWrapText(true);

    }
/*
Кнопка "зашифрувати"
 */
    @FXML// анатоємо даний метод для того щоб компілятор розумів, що дія проводитьс з файлом FXML
    public void encryptText() {
        //Перевіряємо чи поле ключа є пустим
        if (textFieldKey_encrypt.getText().equals(null) || textFieldKey_encrypt.getText().equals("")) {
            DialogMessage.keyError();// викликаємо повідомлення з помилкою
        } else {
            String text = textArea_encrypt.getText(); //
            String key = textFieldKey_encrypt.getText();
            byte[] arr = new byte[0];
            try {
                arr = CipherXOR.xorЕncrypt(text, key.getBytes());// записуємо зашифрований в масив байт
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            FileController.recordFile(FileController.pathOfSave(), arr);// запсиуємо масив байт в файл (вказуємо абсолютний шлях)
            DialogMessage.successfullCript();// виводимо повідомлення про успішне  шифрування
        }
    }

    @FXML
    public void dencryptText() {
        if (textFieldKey_dencrypt.getText().equals(null) || textFieldKey_dencrypt.getText().equals("")) {
            DialogMessage.keyError();
        } else {
            String textDecrypt = null;
            String key = textFieldKey_dencrypt.getText();

            try {
                textDecrypt = CipherXOR.xorDecrypt(FileController.readFile(pathOfFile), key.getBytes());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            textArea_dencrypt.setText(textDecrypt);// передаємо в TExtArea розшифрований текст
        }
    }

    /*
    Повертає абсолютний шлях зашифрованого файлу
     */
    @FXML
    public void FileChoos() {
        textField_filePath.setText("");//Даємо текстовому полю пусте значення, щоб уникнути помилок
        pathOfFile = FileController.fileChoos();//записуємо шлях файлу в глобальну змінну
        textField_filePath.setText(pathOfFile);//передаємо абсолютний шлях в текстове поле
    }

/*
Викликає вікно з  інформацією про автора
 */
    @FXML
    public void visbleAuthor() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AuthorFrame.fxml"));//завантажуємо FXML документ в пам'ять
        Parent root1 = (Parent) fxmlLoader.load();// створюємо базовий клас для нашого контейнера та завантажуємо в нього наш файл FXML
        Stage stage = new Stage(); // створюємо контейнер для нового вікна
        stage.initModality(Modality.APPLICATION_MODAL);// Задаємо режим відображення вікна (поки відкрите це вікно ми нічого не можемо робити з іншим вікном програми)
        stage.setTitle("Автор");
        stage.setScene(new Scene(root1));//передаємо в контейнер створену сцену
        stage.show(); //відображуємо нашу сцену

    }
/*
Викликає методи для збереження розшифрованого документу
 */

    @FXML
    public void saveRecsult() {
        String path = FileController.pathOfSave();//Отримуємо абсолютний шлях для збереження
        FileController.recordFile(path, textArea_dencrypt.getText().getBytes());//Зберігаємо розшифровану інформацію по вказаному шляху
    }
/*
Метод викликає вікно з інформацією про автора
 */
    @FXML
    public void getInstruction() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InstructionFrame.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Інструкція");
        stage.setScene(new Scene(root1));
        stage.setMinWidth(600);
        stage.setMinHeight(503);
        stage.show();
    }
}
