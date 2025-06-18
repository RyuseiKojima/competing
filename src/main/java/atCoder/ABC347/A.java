package atCoder.ABC347;

import java.util.ArrayList;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a%k == 0) {
                results.add(a/k);
            }
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i));
            if (i < results.size()-1) System.out.print(" ");
        }
        System.out.println();

        sc.close();
    }
}
