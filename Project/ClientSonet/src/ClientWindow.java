package ClientSonet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

/**
 * Клас графічного зображення вікна користувача.
 */
public class ClientWindow extends JFrame {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 3443;
    /**Клієнтський сокет*/
    private Socket clientSocket;
    /** Вхідні повідомлення*/
    private Scanner inMessage;
    /** Вихідні повідомлення*/
    private PrintWriter outMessage;
    /** Поле тексту*/
    private final JEditorPane jtaTextAreaMessage;
    /** Ім'я користувача*/
    private String clientName = "";

    /**
     * Функція отримання ім'я користувача
     * @return повертає ім'я користувача
     */
    public String getClientName() {
        return this.clientName;
    }

    /**
     * Конструктор графічного вікна
     */
    public ClientWindow(){
        try {
            //Під'єднуємося до сервера
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Задаємо параметри єлемментів на фоні
        setBounds(600,200,400,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jtaTextAreaMessage = new JEditorPane();
        jtaTextAreaMessage.setEditable(false);
        jtaTextAreaMessage.setContentType("text/html");
        JScrollPane jsp = new JScrollPane(jtaTextAreaMessage);
        add(jsp, BorderLayout.CENTER);

        //label буде відображати ім'я користувача та чи знаходиться ім'я у файлі
        JPanel TextPanel = new JPanel(new BorderLayout());
        add(TextPanel, BorderLayout.NORTH);
        JLabel jlName = new JLabel("Name: ");
        TextPanel.add(jlName, BorderLayout.WEST);
        JLabel jlInFile = new JLabel("In file: ");
        TextPanel.add(jlInFile, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        //Кнопка jbRandomSonet відповідає за генерацію нового сонета
        JButton jbRandomSonet = new JButton("Random Sonet");
        bottomPanel.add(jbRandomSonet,BorderLayout.NORTH);

        //Кнопка jbAdd відповідає за додавання ім'я до файлу клієнтів
        JButton jbAdd = new JButton("Add");
        bottomPanel.add(jbAdd,BorderLayout.CENTER);

        //Кнопка jbRemove відповідає за видалення ім'я з файлу клієнтів
        JButton jbRemove = new JButton("Remove");
        bottomPanel.add(jbRemove,BorderLayout.SOUTH);

        //Прописуємо обробник події при настисканні jbRandomSonet
        //Відправляє команду "random sonet"
        jbRandomSonet.addActionListener(e -> {
            if (!clientName.trim().isEmpty()){
                sendMsg("random sonet");
            }
        });

        //Прописуємо обробник події при настисканні jbAdd
        //Відправляє команду "add member"
        jbAdd.addActionListener(e -> {
            if (!clientName.trim().isEmpty()){
                sendMsg("add member");
            }
        });

        //Прописуємо обробник події при настисканні jbRemove
        //Відправляє команду "remove member"
        jbRemove.addActionListener(e -> {
            if (!clientName.trim().isEmpty()){
                sendMsg("remove member");

            }
        });

        //В окремому потоці починаємо роботу з сервером
        new Thread(() -> {
            try {
                //Встановлюємо ім'я користувача та відправляємо його до сервера
                //Якщо ім'я не введено, то за замовчуванням ім'я клієнту "Default"
                clientName = JOptionPane.showInputDialog("<html><h2>Як вас звати?");
                if (!clientName.trim().isEmpty())
                    sendMsg(clientName);
                else
                    sendMsg("Default");
                jlName.setText("Your name: " + clientName);

                //Якщо є вхідне повідомлення, то зчитуємо його та виводимо на поле тексту
                while (true) {
                    if (inMessage.hasNext()) {
                        String inMes = inMessage.nextLine();
                        if (inMes.indexOf("In file")==0)
                            jlInFile.setText(inMes);
                        else
                            jtaTextAreaMessage.setText(inMes);
                    }
                }
            } catch (Exception ignored) {
            }
        }).start();

        //Встановлюємо обробник події закриття вікна
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    //Відправляємо повідомлення що клієнт вийшов
                    outMessage.println("##session##end##");
                    outMessage.flush();
                    outMessage.close();
                    inMessage.close();
                    clientSocket.close();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });
        setVisible(true);
    }

    /**
     * Функція відправки команди до сервера
     * @param command команда, яку потрібно відправити
     */
    public void sendMsg(String command) {
        outMessage.println(command);
        outMessage.flush();
    }
}
