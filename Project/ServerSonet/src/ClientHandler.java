package ServerSonet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Клас, який оброблює підключених до сервера клієнтів
 */
public class ClientHandler implements Runnable{
    /** Ім'я користувача*/
    private String name;
    /** Екземпляр нашого сервера*/
    private Server server;
    /** Вихідні повідомлення*/
    private PrintWriter outMessage;
    /** Вхідні повідомлення*/
    private Scanner inMessage;

    /**
     * Конструктор класу
     * @param socket клієнтський сокет
     * @param server сервер із яким ми працюємо
     */
    public ClientHandler(Socket socket, Server server){
        try {
            this.server = server;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Перевизначаємо матод run()
     */
    @Override
    public void run() {
        try {
            //Зчитуємо ім'я користувача
            while (true){
                if (inMessage.hasNext()){
                    this.name = inMessage.nextLine();
                    if (server.inFile(this.name))
                        sendMsg("In file: yes");
                    else
                        sendMsg("In file: no");
                    break;
                }
            }

            while (true) {
                //Якщо від користувача прийшла команда
                if (inMessage.hasNext()) {
                    //Зчитуємо команду
                    String clientMessage = inMessage.nextLine();
                    //Якщо клієнт вийшов, то цикл преривається
                    if (clientMessage.equalsIgnoreCase("##session##end##")) {
                        System.out.println("Member " + this.name + "End");
                        break;
                    }
                    //Якщо команда "random sonet", то відправляємо рандомний сонет
                    else if (clientMessage.equals("random sonet")){
                        sendRandomSonet();
                    }
                    //Якщо команда "add member", то додаємо користувача до файлу клуєнтів
                    else if (clientMessage.equals("add member")){
                        server.saveNewMember(this.name);
                        sendMsg("In file: yes");
                    }
                    //Якщо команда "remove member", то видаляємо користувача з файлу клуєнтів
                    else if (clientMessage.equals("remove member")){
                        server.removeMember(this.name);
                        sendMsg("In file: no");
                    }
                    //Виводимо зчитану команду у консоль
                    System.out.println(this.name + " make: " + clientMessage);
                }
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.close();
        }
    }

    /**
     * Якщо клієнт виходит з додатку, то видаляємо його зі списку клієнтів, що онлайн
     */
    public void close() {
        server.removeClient(this);
    }

    /**
     * Функція відправки рандомного сонету
     */
    public void sendRandomSonet(){
        //Рандомно обираємо номер сонета
        int sonet = ThreadLocalRandom.current().nextInt(1,154+1);
        try {
            //Відправляємо сонет в html форматі
            String msg = "<center><big>Sonet " + sonet + "</big><br>" + Content.getSonet(sonet) + "</center>";
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Функція отримання ім'я користувача
     * @return повертає ім'я користувача
     */
    public String getName() {
        return name;
    }

    /**
     * Фнкція відправки повідомлення клієнту
     * @param msg текст повідомлення
     */
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
