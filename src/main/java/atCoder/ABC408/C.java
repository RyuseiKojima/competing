package atCoder.ABC408;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] diff = new int[n + 1]; // 差分配列（いもす法）

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt();     // rは非包含の位置にしておく
            diff[l]++;
            if (r < n) diff[r]--;
        }
        sc.close();

        int minPaint = n;
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            minPaint = Math.min(minPaint, current);
        }
        System.out.println(minPaint);
    }
}
