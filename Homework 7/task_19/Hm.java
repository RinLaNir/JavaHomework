package task_19;

import java.util.Scanner;

public class Hm {
    public void funk(String str){
        char temp;
        for (int i=0;i<str.length();i++){
            temp = str.charAt(i);
            if (Character.isDigit(temp))
                System.out.print(temp);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        str = in.nextLine();
        System.out.println(str.replaceAll("[^\\d]", ""));
        System.out.println(str.replaceAll("[0-9]", ""));
    }
}
