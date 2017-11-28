import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InstructionController {
    @FXML
    public TextArea textArea_encrypt;
    @FXML
    public TextArea textArea_dencrypt;

    /*
    Метод викликається одразу після завантаження графіки в пам'ять
     */
    public void initialize() {
        textArea_encrypt.setEditable(false);//забороняємо змінювати дані в TextArea
        textArea_dencrypt.setEditable(false);//
        textArea_encrypt.setWrapText(true);//вмикаэмо перенос тексту в TextArea
        textArea_dencrypt.setWrapText(true);
    }
}
