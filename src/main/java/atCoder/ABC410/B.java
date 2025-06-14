package atCoder.ABC410;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] boxes = new int[n+1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int number = sc.nextInt();
            if (number > 0) {
                boxes[number]++;
                sb.append(number);
            } else {
                int min = 101;
                int set = 0;
                for (int j = 1; j <= n; j++) {
                    int check = boxes[j];
                    if (check < min) {
                        min = check;
                        set = j;
                    }
                }
                boxes[set]++;
                sb.append(set);
            }
            if (i != q - 1) {
                sb.append(" ");
            }
        }
        sc.close();
        System.out.println(sb.toString());
    }
}
