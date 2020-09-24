import java.util.Scanner;

/**
 * <b>Зробив:</b>
 * <pre>Авраменко Нікіта</pre>
 * <b>Дата отримання завдання:</b>
 * <pre>16.09.2020</pre>
 * <b>Номер завдання:</b>
 * <pre>2.8</pre>
 */

public class Task_2_8 {

    /**
     * main функція
     * @param args
     */
    static public void main(String[] args){
        System.out.println("Авраменко Нікіта, перша підгруппа комп'ютерної математики\n" +
                "Дата отримання завдання 16.09.2020\n" +
                "Номер завдання 2.8\n");
        System.out.println("Введіть два числа: ");

        long x, y;
        Scanner in = new Scanner(System.in);
        x = uInt(in.nextLong());
        y = uInt(in.nextLong());

        System.out.println("Sum: " + uInt(x+y));
        System.out.println("Sub: " + uInt(x-y));
        System.out.println("Mul: " + uInt(x*y));
        System.out.println("Div: " + uInt(x/y));
        System.out.println("Rem: " + uInt(x%y));

    }

    /**
     * Перетворюємо число на беззнаковий тип
     * @param x - вхідне число
     * @return unsigned int x (long x & 0xffffffffL)
     */
    static long uInt(long x){
        return x & 0xffffffffL;
    }
}
