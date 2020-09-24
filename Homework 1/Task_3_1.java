import java.util.Scanner;

/**
 * <b>Зробив:</b>
 * <pre>Авраменко Нікіта</pre>
 * <b>Дата отримання завдання:</b>
 * <pre>18.09.2020</pre>
 * <b>Номер завдання:</b>
 * <pre>3.1</pre>
 */

public class Task_3_1 {
    /**
     * Основний метод main. Систему двух лінійних рівнянь розв'язано методом Крамера.
     * @param args
     */
    static public void main(String[] args){
        System.out.println("Авраменко Нікіта, перша підгруппа комп'ютерної математики\n" +
                "Дата отримання завдання 18.09.2020\n" +
                "Номер завдання 3.1\n");

        double[][] mtr = new double[2][3];
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть матрицю коефіціентів системи двух лінійних рівнянь із двома невідомими: ");
        for (int i=0; i<2; i++){
            for (int j=0; j<3; j++){
                mtr[i][j] = in.nextDouble();
            }
        }
        double d, d1, d2;
        d = mtr[0][0]*mtr[1][1] - mtr[1][0]*mtr[0][1];
        d1 = mtr[0][2]*mtr[1][1] - mtr[1][2]*mtr[0][1];
        d2 = mtr[0][0]*mtr[1][2] - mtr[1][0]*mtr[0][2];
        //System.out.println(d+" "+d1+" "+d2);

        System.out.printf("\nx1 = %.2f\nx2 = %.2f",d1/d,d2/d);
    }
}
