package atCoder.ABC410;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class D {
    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 頂点数
        int M = sc.nextInt();  // 辺の数

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();
            graph.get(A).add(new Edge(B, W));
        }

        // dist[node][xor] = 到達済みかどうか
        boolean[][] visited = new boolean[N + 1][1024];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});  // (現在のノード, 現在のXOR値)
        visited[1][0] = true;

        int answer = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int xor = current[1];

            if (node == N) {
                if (answer == -1 || xor < answer) {
                    answer = xor;
                }
            }

            for (Edge edge : graph.get(node)) {
                int next = edge.to;
                int nextXor = xor ^ edge.weight;
                if (!visited[next][nextXor]) {
                    visited[next][nextXor] = true;
                    queue.offer(new int[]{next, nextXor});
                }
            }
        }

        System.out.println(answer);
    }
}
