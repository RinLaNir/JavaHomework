import java.util.Scanner;

public class Task_5_3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        if (!in.hasNextInt()) {
            System.out.println("no longest consecutive run");
            return;
        }

        int prev = in.nextInt();
        int count = 1;
        int best = prev;
        int bestCount = count;

        while (in.hasNextInt()) {
            // read in the next value
            int current = in.nextInt();

            // update current run
            if (current == prev)
                count++;
            else {
                prev = current;
                count = 1;
            }

            if (count > bestCount) {
                bestCount = count;
                best = current;
            }
        }

        System.out.println("Longest run: " + bestCount + " consecutive " + best + "s");
    }
}
