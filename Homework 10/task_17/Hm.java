package task_17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Hm {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        String line;
        try {
            FileReader reader = new FileReader("C:\\UnivEdu\\kurs_3\\Java\\Java Homework\\HW10\\src\\task_17\\task17.txt");
            BufferedReader bf = new BufferedReader(reader);
            while ((line = bf.readLine()) != null) {
                String[] str = line.toLowerCase().split("([(){},.\\s]+)");
                for (String s : str) {
                    int count = map.getOrDefault(s,0);
                    map.put(s,count + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set s = map.entrySet();
        Iterator i = s.iterator();

        while (i.hasNext()) {
            Map.Entry m = (Map.Entry)i.next();

            String key = (String)m.getKey();
            int value = (Integer)m.getValue();

            System.out.println("Key : " + "\"" + key + "\""
                    + "  value : " + value);
        }
    }
}
