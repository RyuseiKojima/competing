package atCoder.ABC423;

import java.util.Scanner;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int R = sc.nextInt();
        int[] doors = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            doors[i] = sc.nextInt();
        }

        int left_rock = 0;
        int right_rock = N + 1;

        for (int i = 1; i <= R; i++) {
            if (doors[i] == 1) {
                left_rock = i;
            } else {
                break;
            }
        }
        for (int i = N; i > R; i--) {
            if (doors[i] == 1) {
                right_rock = i;
            } else {
                break;
            }
        }
        int cnt = 0;
        for (int i = left_rock + 1; i < right_rock; i++) {
            if (doors[i] == 0) {
                cnt++;
            } else {
                cnt += 2;
            }
        }
        System.out.println(cnt);

        sc.close();
    }
}
