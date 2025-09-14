package atCoder.ABC423;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] rooms = new int[N + 1];
        int[] doors = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            doors[i] = sc.nextInt();
        }
        rooms[0] = 1;
        rooms[N] = 1;

        for (int i = 1; i < N; i++) {
            if (doors[i] == 0) {
                rooms[i] = 1;
            } else {
                break;
            }
        }
        for (int i = N; i > 1; i--) {
            if (doors[i] == 0) {
                rooms[i - 1] = 1;
            } else {
                break;
            }
        }
        int ans = 0;
        for (int i = 1; i < N; i++) {
            if (rooms[i] == 0) {
                ans++;
            }
        }
        System.out.println(ans);

        sc.close();
    }
}
