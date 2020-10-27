import java.util.Random;
import java.util.Scanner;

public class Task_6_1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть число n: ");
        int n;
        n = in.nextInt();
        int[][] matrix = new int[n][n];
        char str;
        System.out.println("Оберіть формат вводу r/c(random/console): ");
        str = in.next().charAt(0);

        if (str == 'r')
            matrix = rand(n);
        if (str == 'c')
            matrix = con(n);

        //show(matrix,n);
        System.out.println("Введіть k-ту позицію: ");
        int k =in.nextInt();
        if (k<1 || k >5){
            System.out.println("ERROR VALUE k");
            return;
        }
        //sortMtr(matrix,k);
        sortMtrCol(matrix,k);
        show(matrix,n);

    }

    static int[][] rand(int n){
        Random r = new Random();
        int[][] mtr=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                mtr[i][j]=r.nextInt(2*n+1)-n;
                System.out.print(mtr[i][j]+"\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        return mtr;
    }
    static int[][] con(int n){
        Scanner scan = new Scanner(System.in);
        int[][] mtr=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                mtr[i][j]=scan.nextInt();
            }
        }
        return mtr;
    }

    static void show(int[][] mtr, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mtr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void sortMtr(int[][] mtr, int k){
        int[] temp;
        k=k-1;
        for (int i= mtr.length-1;i>=0;i--){
            for (int j=0;j<i;j++){
                if (mtr[j][k] > mtr[j+1][k]){
                    temp = mtr[j];
                    mtr[j] = mtr[j+1];
                    mtr[j+1] = temp;
                }
            }
        }
    }

    static void sortMtrCol(int[][] mtr, int k){
        int temp;
        k=k-1;
        for (int i= mtr.length-1;i>=0;i--){
            for (int j=0;j<i;j++){
                if (mtr[k][j] > mtr[k][j+1]){
                    for (int l=0;l< mtr.length;l++){
                        temp = mtr[l][j];
                        mtr[l][j] = mtr[l][j+1];
                        mtr[l][j+1] = temp;
                    }
                }
            }
        }
    }
}
