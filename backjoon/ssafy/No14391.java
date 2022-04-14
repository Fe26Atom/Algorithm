package backjoon.ssafy;
//https://www.acmicpc.net/problem/14391

// 종이 조각

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14391 {
	
	static int N, M;
	static int mat[][];
	static boolean visit[][];
	static Queue<int[]> queue;
	
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j)-'0';
			}
		}
		
		dfs(0);
		System.out.println(max);
		br.close();
	}

	private static void dfs(int depth) {
		if(depth == N * M) {
			check();
			return;
		}
		
		visit[depth/M][depth%M] = true;
		dfs(depth + 1);
		
		visit[depth/M][depth%M] = false;
		dfs(depth + 1);
	}

	private static void check() {
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			int num = 0;
			for(int j = 0; j<M; j++) {
				if(visit[i][j]) {
					num = num * 10 + mat[i][j];
				} else {
					sum += num;
					num = 0;
				}
			}
			sum += num;
		}
		
		for(int j=0; j<M; j++) {
			int num = 0;
			for(int i=0; i<N; i++) {
				if(!visit[i][j]) {
					num= num * 10 + mat[i][j];
				} else {
					sum += num;
					num = 0;
				}
			}
			sum += num;
		}
		
		max= Math.max(sum, max);
	}
}
