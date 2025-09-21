package atCoder.ABC424;

import java.util.*;

class C {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
		
		// 隣接リストの作成
		HashSet<Integer>[] G = new HashSet[N + 1];
		for (int i = 0; i <= N; i++) {
			G[i] = new HashSet<Integer>();
		}
		for (int i = 1; i <= N; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			G[A].add(i);
			G[B].add(i);
		}

		sc.close();

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		queue.add(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int neighbor : G[node]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}

		int totalSkill = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				totalSkill++;
			}
		}
		System.out.println(totalSkill);
	}
}