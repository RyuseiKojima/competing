package atCoder.ABC420;

import java.util.*;

class D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();

		char[][] grid = new char[H + 1][W + 1];
		int[][] db_1 = new int[H + 1][W + 1]; // ボタンを押していない状態
		int[][] db_0 = new int[H + 1][W + 1]; // ボタンを押した状態
        int[] start = new int[2 + 1];
        int[] goal = new int[2 + 1];

		for (int i = 1; i <= H; i++) {
			String line = sc.next();
			for (int j = 1; j <= W; j++) {
				char ch = line.charAt(j - 1);
                if (ch == 'S') {
                    start[1] = i;
                    start[2] = j;
                } else if (ch == 'G') {
                    goal[1] = i;
                    goal[2] = j;
                }
				grid[i][j] = ch;
				db_1[i][j] = 1_000_000_000; // 初期化
				db_0[i][j] = 1_000_000_000; // 初期化
			}
		}

		sc.close();

		PriorityQueue<State> pq = new PriorityQueue<State>();
		pq.add(new State(start[1], start[2], 0, 1));
		db_1[start[1]][start[2]] = 0;

		while (!pq.isEmpty()) {
			State cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int d = cur.dist;
			int button_state = cur.button_state;

			if ((button_state == 1 && d > db_1[x][y]) || (button_state == 0 && d > db_0[x][y])) continue; // すでに最短距離が確定している場合はスキップ

            // スイッチの切り替え
            if (grid[x][y] == '?') {
                button_state ^= 1;
            }

			// 4方向に移動
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 1 || nx > H || ny < 1 || ny > W) continue; // 範囲外チェック
				if (grid[nx][ny] == '#' || (button_state == 1 && grid[nx][ny] == 'x') || (button_state == 0 && grid[nx][ny] == 'o')) continue; // 壁チェック

				// 移動コストの計算
				if (button_state == 1 && db_1[nx][ny] > d + 1) {
					db_1[nx][ny] = d + 1;
					pq.add(new State(nx, ny, d + 1, button_state));
				} else if (button_state == 0 && db_0[nx][ny] > d + 1) {
					db_0[nx][ny] = d + 1;
					pq.add(new State(nx, ny, d + 1, button_state));
				}
			}
		}

        int result = Math.min(db_0[goal[1]][goal[2]], db_1[goal[1]][goal[2]]);

		System.out.println(result == 1_000_000_000 ? -1 : result);
	}


	// 移動方向を表す配列
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {1, 0, -1, 0};

	/**
	 * 状態を表すクラス
	 * (x, y) の座標と、スタート地点からの距離を保持します。
	 */
	private static class State implements Comparable<State> {
		int x, y, dist, button_state;
		State(int x, int y, int dist, int button_state) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.button_state = button_state;
		}
		public int compareTo(State other) {
			return Integer.compare(this.dist, other.dist);
		}
	}
}