package atCoder.ABC419;

import java.util.Scanner;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int x_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE;
        int y_max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            x_min = Math.min(x_min, x);
            x_max = Math.max(x_max, x);
            y_min = Math.min(y_min, y);
            y_max = Math.max(y_max, y);
        }

        sc.close();

        int x_len = x_max - x_min;
        int y_len = y_max - y_min;

        int len = Math.max(x_len, y_len);

        System.out.println(len % 2 == 0 ? len / 2 : (len / 2) + 1);
    }
}
