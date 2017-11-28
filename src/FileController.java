
import javafx.stage.FileChooser;
import java.io.*;


public class FileController {

    /*
    Метод вибирає файл та повертає його абсолютний шлях
     */
    public static String fileChoos() {
        FileChooser chooser = new FileChooser();//Класс роботи з діалогом вибору
        chooser.setTitle("Виберіть файл");
        File file = chooser.showOpenDialog(null);//відкриваємо діалогове вікно
        if (file != null) {
            String string = file.getAbsolutePath().toString(); //Отримуємо абсолютний шлях файлу та записуємо його у змінну
            return string;
        } else {
           DialogMessage.fileError(); // в разі помилки виводимо повідомлення про помилку
        }

        return null;
    }

/*
Метод для вибору шляху збереження файлу
 */
    public static String pathOfSave() {
        FileChooser fileChooser = new FileChooser();//Класс роботи з діалогом вибору і збереження
        fileChooser.setTitle("Зберегти документ");//Заголовок діалога
        //Перелік всіх форматів в яких можна зберегти файл
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("No formats", "*.*"),
                new FileChooser.ExtensionFilter("TXT file", "*.txt"),
                new FileChooser.ExtensionFilter("MS Word", "*.doc")
        );
        File file = null;
        try {
            file = fileChooser.showSaveDialog(null);//відкриваємо діалогове вікно
        } catch (Exception e) {
            e.printStackTrace(); //в разі помилки виводими ЕрорЛог в консоль
        }
        return file.getAbsolutePath();
    }

    /*
    мето записує (створює) файл із заданого масиву байт по вказаному абсолютному шляху
     */
    public static void recordFile(String path, byte[] info) {
        //Відкриваємо поток для запису (Поток вкінці операції автоматично буде закритий)
        try (FileOutputStream fos = new FileOutputStream(new File(path))) {
            fos.write(info);
        } catch (java.io.IOException e) {
           DialogMessage.fileRecordError();//викликаємо діалогове вікно
        }
    }

/*
Метод зчитує інформацію з файлу. На вхід приємає абсолютний шлях файлу
 */
    public static String readFile(String path) {
        String line = "";
        //Відриваємо поток для читання файлу і передаємо абсолютний шлях файлу який треба прочитати
        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                line += (char) c;
            }
        } catch (Exception e) {
        DialogMessage.fileReadrdError();// повідомлення про помилку
        }
        return line;
    }


}

