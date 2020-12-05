package task_16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CustomPair {
    public int key;
    public int value;
    public CustomPair(int key, int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{num=" + key +
                ", size=" + value + "}";
    }
}

public class Hm {
    static Map<String, CustomPair> A(ArrayList<String[]> text){
        Map<String, CustomPair> map = new HashMap<>();
        for (String[] el :
                text) {
            CustomPair count = map.getOrDefault(el[1], new CustomPair(0,0));
            count.key++;
            int a = Integer.parseInt(el[0]);
            count.value = count.value + a*a*a;
            map.put(el[1], count);
        }
        return map;
    }

    static Map<String, Integer> B(ArrayList<String[]> text){
        Map<String, Integer> map = new HashMap<>();
        for (String[] el :
                text){
            if (el[2].equals("дерев'яний") && el[0].equals("3")){
                int count = map.getOrDefault("кількості дерев'яних кубиків  із ребром 3 см",0);
                map.put("кількості дерев'яних кубиків  із ребром 3 см", count+1);
            }
            else if (el[2].equals("металевий") && Integer.parseInt(el[0]) > 5){
                int count = map.getOrDefault("кількості металевих кубиків ребром, більшим за 5 см",0);
                map.put("кількості металевих кубиків ребром, більшим за 5 см", count+1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        ArrayList<String[]> text = new ArrayList<>();
        try {
            File file = new File("C:\\UnivEdu\\kurs_3\\Java\\Java Homework\\HW8\\src\\task_16\\task16.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                text.add(reader.nextLine().split("[ ]+"));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(A(text));
        System.out.println(B(text));
    }
}
