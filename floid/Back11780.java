package floid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back11780 {
	// 플로이드

	// 최단 경로 기억하는 2차원 배열

	static final int INF = 10000001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int mat[][] = new int[N + 1][N + 1];
		int dist[][] = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = INF;
				if (i != j)
					mat[i][j] = INF;
			}
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);

			mat[a][b] = Math.min(mat[a][b], c);
			dist[a][b] = a;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (mat[i][j] > mat[i][k] + mat[k][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
						dist[i][j] = dist[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (mat[i][j] == INF)
					sb.append(0 + " ");
				else
					sb.append(mat[i][j] + " ");
			}
			sb.append("\n");
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] == INF)
					sb.append(0 + "\n");

				else {
					int pre = j;
					stack.push(j);
					while (i != dist[i][pre]) {
						pre = dist[i][pre];
						stack.push(pre);
					}
					sb.append((stack.size() + 1) + " ");
					sb.append(i + " ");
					while (!stack.empty())
						sb.append(stack.pop() + " ");
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);

		br.close();
	}
}
