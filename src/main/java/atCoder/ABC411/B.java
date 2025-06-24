package atCoder.ABC411;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] values = new int[n-1];

        for (int i = 0; i < values.length; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < values.length; i++) {
            int result = 0;
            for (int j = i; j < values.length; j++) {
                result += values[j];
                System.out.print(result);
                if (j < values.length-1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }

        sc.close();
    }
}
