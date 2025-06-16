package atCoder.ABC348;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n+1];
        int[] y = new int[n+1];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 1; i <= n; i++) {
            double max = 0;
            int point = 0;
            for (int j = 1; j <= n; j++) {
                double length = Math.pow(Math.abs(x[i] - x[j]), 2) + Math.pow(Math.abs(y[i] - y[j]), 2);
                if (length > max) {
                    max = length;
                    point = j;
                } else if (length == max) {
                    point = Math.min(point, j);
                }
            }
            System.out.println(point);
        }
    }
}
