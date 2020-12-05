package task_2;

import java.util.Scanner;

public class Hm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        System.out.print("Введіть рядок: ");
        str = in.nextLine();

        System.out.println("Позиція першої коми(якщо коми не має то виводить -1): " + str.indexOf(","));
        System.out.println("Позиція останньої коми(якщо коми не має то виводить -1): " + str.lastIndexOf(","));
        System.out.println("Кількість ком: " + (str.split(",",-1).length-1));
    }
}
