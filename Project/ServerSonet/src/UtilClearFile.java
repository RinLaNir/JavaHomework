package ServerSonet;

import java.io.*;
import java.util.ArrayList;

/**
 * Допоміжний класс для очищення файлу клієнтів, якщо це буде потрібно
 */
public class UtilClearFile {
    public static void main(String[] args) {
        //Шлях до директорії
        String mypath = "C:\\UnivEdu\\kurs_3\\Java\\Project\\src\\ServerSonet\\";

        try {
            //Записуємо у файл та закриваємо його
            FileOutputStream writeData = new FileOutputStream(mypath + "members.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(new ArrayList<String>());
            writeStream.flush();
            writeStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
