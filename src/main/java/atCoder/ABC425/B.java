package atCoder.ABC425;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
            list.add(i);
        }

        sc.close();

        boolean flg = true;
        int[] Ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (A[i] == -1) continue;
            if (list.contains(A[i])) {
                Ans[i] = A[i];
                list.remove(Integer.valueOf(A[i]));
            } else {
                flg = false;
                break;
            }
        }

        if (!flg) {
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
        for (int i = 1; i <= N; i++) {
            if (Ans[i] == 0) {
                Ans[i] = list.get(0);
                list.remove(0);
            }
            System.out.print(Ans[i] + " ");
        }
        System.out.println();
    }
}
