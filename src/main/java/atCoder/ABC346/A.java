package atCoder.ABC346;

import java.util.ArrayList;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            results.add(a[i] * a[i+1]);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i));
            if (i < results.size()-1) System.out.print(" ");
        }
        System.out.println();

        sc.close();
    }
}
