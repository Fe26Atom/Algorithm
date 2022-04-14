package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12100 {
	// 1. 현재 좌표값들을 봄
	// 2. for문으로 애들을 다 이동시켜봄
	// 3. 만약 이동하다가 만났을 때 같으면 합치가 아니면 충돌
	// 4. 그 깊이가 5가 될때까지 반복
	// -> dfs로 문제 풀이
	
	static int max = Integer.MIN_VALUE;
	static int N;
	
	static int dirx[] = { -1, 0, 1, 0 };
	static int diry[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int arr[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(max);
		br.close();
		
		
	}

	private static void dfs(int i) {
		// TODO Auto-generated method stub
		
	}

}
