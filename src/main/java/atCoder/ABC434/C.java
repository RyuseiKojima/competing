package atCoder.ABC434;

import java.util.*;

class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int now = 0;
            int N = sc.nextInt();
            int max_height = sc.nextInt();
            int min_height = max_height;
            boolean success = true;

            for (int j = 0; j < N; j++) {
                int next_time = sc.nextInt();
                int next_min_target = sc.nextInt();
                int next_max_target = sc.nextInt();
                int time_diff = next_time - now;
                max_height += time_diff;
                min_height = Math.max(min_height - time_diff, 1);  
                
                if (next_min_target > max_height || next_max_target < min_height) {
                    success = false;
                }

                now = next_time;
                max_height = Math.min(max_height, next_max_target);
                min_height = Math.max(min_height, next_min_target);
            }

            System.out.println(success ? "Yes" : "No");
        }

        sc.close();
    }
}