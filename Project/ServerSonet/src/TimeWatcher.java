package ServerSonet;

import java.text.SimpleDateFormat;

/**
 * Класс, що буде слідкувати за часом. Він перевіряє чи прийшов час розсилати
 * сонети для обраних клієнтів із файлу
 */
public class TimeWatcher implements Runnable {
    private final Server server;
    private static final String HOST = "localhost";
    private static final int PORT = 3443;
    private final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    /**Година коли потрібно розіслати сонети*/
    private String mainTime = "17:16";
    /**Година оновлення флагу на false*/
    private String TIME = "00:00";
    /**Помічає чи були вже розіслані сонети*/
    private boolean flag = false;

    /**
     * Конструктор класу
     * @param server передаємо екземпляр серверу
     */
    public TimeWatcher(Server server){
        this.server = server;
    }

    /**
     * Головний потік класу. Кожну секунду порівнюємо поточний час на комьютері
     * з часом, коли потрібно розіслати сонети. Якщо вони збігаються, то
     * запускаємо відповідну команду головного сервера і встановлюємо флаг
     * на true
     */
    @Override
    public void run() {
        while (true){
            if (formatter.format(System.currentTimeMillis()).equals(mainTime) && !flag){
                flag = true;
                server.sendSonet();
            }
            else if (formatter.format(System.currentTimeMillis()).equals(TIME))
                flag = false;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
