package atCoder.ABC417;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLong());
        }
        for (int i = 0; i < m; i++) {
            long x = sc.nextLong();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == x) {
                    list.remove(j);
                    break;
                }
            }
        }
        sc.close();

        if (list.isEmpty()) {
            return;
        }

        for (Long num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
