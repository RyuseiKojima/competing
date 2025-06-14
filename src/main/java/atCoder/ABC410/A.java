package atCoder.ABC410;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k) cnt++;
        }
        System.out.println(cnt);
        sc.close();
    }
}
