package atCoder.ABC434;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] sizes_sum = new int[M + 1];
        int[] types_count = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            int type = sc.nextInt();
            int size = sc.nextInt();
            sizes_sum[type] += size;
            types_count[type]++;
        }

        for (int i = 1; i <= M; i++) {
            double average = (double) sizes_sum[i] / types_count[i];
            System.out.printf("%.10f%n", average);
        }

        sc.close();
    }
}
