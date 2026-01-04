package atCoder.ABC439;

import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX = 10000000;
        int[] counts = new int[MAX + 1];
        for (int i = 1; i * i <= MAX; i++) {
            for (int j = i + 1; j * j <= MAX; j++) {
                int val = i * i + j * j;
                if (val > MAX) {
                    break;
                }
                counts[val]++;
            }
        }

        List<Integer> anses = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == 1) {
                anses.add(i);
            }
        }

        System.out.println(anses.size());
        for (int i = 0; i < anses.size(); i++) {
            System.out.print(anses.get(i));
            if (i != anses.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        sc.close();
    }
}