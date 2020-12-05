package task_13;

import java.util.Scanner;

public class Hm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        str = in.nextLine();

        System.out.println(str.replaceAll("([A-Za-z])\\1+", "$1"));
    }
}
