package ServerSonet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Клас, який описує логіку роботи сервера
 */
public class Server {
    /** Порт який буде прослуховувати наш сервер*/
    final static int PORT = 3443;
    /** Директорія, де знаходится файл members.ser*/
    private final String mypath = "C:\\UnivEdu\\kurs_3\\Java\\Project\\src\\ServerSonet\\";
    /** Список користувачів, які зараз підключені до сервера*/
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    /**
     * Констуктор класу. У головному циклі він оброблює підключення
     * та запускає для них новий потік
     */
    public Server() {
        Socket clientSocket = null;
        ServerSocket serverSocket = null;

        try {
            //Створюємо серверний сокет
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server start");
            //Запускаємо потік, який буде слідкувати за часом
            new Thread(new TimeWatcher(this)).start();
            //Заупскаємо цикл
            while (true){
                //Чекаємо підключень
                clientSocket = serverSocket.accept();
                //Оброблюємо підключення
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                //Запускаємо подальшу обробку підключення у новому потоці
                new Thread(client).start();
            }
        }
        catch (IOException ex){
            System.out.println("ERROR");
            ex.printStackTrace();
        }
        finally {
            try {
                //Закінчуємо роботу сервера
                clientSocket.close();
                System.out.println("Server stoped");
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Функція видалення користувача зі списку підключених користувачів
     * @param client клієнт, якого потрібно прибрати зі списку
     */
    public void removeClient(ClientHandler client){
        clients.remove(client);
    }

    /**
     * Функція відправки рандомного сонету всім обраним користувачам з файлу
     */
    public void sendSonet(){
        //Зчитуємо клієтів з файлу
        ArrayList<String> members = readMemders();
        //Відправляємо кожному рандомний сонет
        for (ClientHandler o : clients){
            if (members.contains(o.getName()))
                o.sendRandomSonet();
        }
    }

    /**
     * Функція зчитування з файлу списку обраних користчвачів
     * @return повертає список обраних користчвачів
     */
    public ArrayList<String> readMemders(){
        ArrayList<String> members = null;
        try {
            FileInputStream readData = new FileInputStream(this.mypath + "members.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            members = (ArrayList<String>) readStream.readObject();
            readStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return members;
    }

    /**
     * Функція запису списку обраних клієтів до файлу
     * @param members список обраних клієнтів
     */
    public void writeMember(ArrayList<String> members){
        try {
            FileOutputStream writeData = new FileOutputStream(this.mypath + "members.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(members);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Функція додавання нового клієнта до файла обраних користувачів
     * @param name клієнт, якого потрібно додати до файлу
     */
    public void saveNewMember(String name){
        ArrayList<String> members = readMemders();
        if (members.contains(name))
            return;
        else
            members.add(name);
        writeMember(members);
    }

    /**
     * Функція видалення клієнта з файлу обраних користувачів
     * @param name  клієнт, якого потрібно видалити з файлу
     */
    public void removeMember(String name){
        ArrayList<String> members = readMemders();
        if (members.contains(name))
            members.remove(name);
        else
            return;
        writeMember(members);
    }

    /**
     * Функцыя, що перевіряє чи є користувач у файлі
     * @param name ім'я користувача
     * @return повертає true або false
     */
    public boolean inFile(String name){
        ArrayList<String> members = readMemders();
        return members.contains(name);
    }
}
