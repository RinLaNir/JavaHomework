package ClientSonet;

import java.util.ArrayList;

/**
 * Імітуємо множину клієнтів
 */
public class MultiStartClientWindow {
    public static void main(String[] args) throws InterruptedException {
        int n = 3;
        ArrayList<ClientWindow> clientWindows = new ArrayList<>();

        for (int i=0;i<n;i++){
            clientWindows.add(new ClientWindow());
            Thread.sleep(100);
        }
    }
}
