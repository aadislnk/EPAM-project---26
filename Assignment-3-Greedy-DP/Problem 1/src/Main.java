import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int maxScholarships(int[] amounts, int budget) {
        Arrays.sort(amounts);

        int count = 0;
        int remaining = budget;

        for (int i = 0; i < amounts.length; i++) {
            if (amounts[i] <= remaining) {
                count++;
                remaining -= amounts[i];
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] amounts = new int[n];
        for (int i = 0; i < n; i++) {
            amounts[i] = sc.nextInt();
        }

        int result = maxScholarships(amounts, b);
        System.out.println(result);

        sc.close();
    }
}