package atCoder.ABC423;
import java.util.*;

class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N + 1];
        int[] B = new int[N + 1];
        int[] C = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }
        sc.close();

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i <= N; i++) {
            queue.offer(new int[]{A[i], B[i], C[i]});
        }

        // 退店時間と退店人数を管理
        PriorityQueue<long[]> leaveQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        long currentTime = 0;
        long currentCapacity = 0;

        while (!queue.isEmpty()) {
            int[] customer = queue.poll();
            long arrivalTime = customer[0];
            int stayTime = customer[1];
            int groupSize = customer[2];

            if (currentCapacity + groupSize > K) {
                // 退店時間が一番早いグループを退店させる
                while (!leaveQueue.isEmpty()) {
                    long[] leaveGroup = leaveQueue.poll();
                    long leaveTime = leaveGroup[0];
                    long leaveSize = leaveGroup[1];
                    currentCapacity -= leaveSize;
                    currentTime = Math.max(currentTime, leaveTime);
                    if (currentCapacity + groupSize <= K) {
                        break;
                    }
                }
            }
            currentTime = Math.max(currentTime, arrivalTime);
            currentCapacity += groupSize;
            System.out.println(currentTime);

            leaveQueue.offer(new long[]{currentTime + stayTime, groupSize});
        }
    }
}
