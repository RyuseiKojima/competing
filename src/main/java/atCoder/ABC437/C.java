package atCoder.ABC437;

import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            Pair[] pairs = new Pair[N];
            long powerSum = 0;

            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                pairs[i] = new Pair(a, b);
                powerSum += b;
            }

            Arrays.sort(pairs);

            long sum = 0;
            
            for (int i = 0; i < N; i++) {
                sum += pairs[i].a + pairs[i].b;
                if (powerSum < sum) {
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.a + this.b, o.a + o.b);
        }
    }
}