package atCoder.ABC440;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N + 1];
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            index.put(T[i], i);
        }

        Arrays.sort(T, 0, N);

        for (int i = 0; i < 3; i++) {
            System.out.print(index.get(T[i]) + 1);

            if (i != 2) System.out.print(" ");
        }

        System.out.println();

        sc.close();
    }
}
