package backjoon.ssafy;
// https://www.acmicpc.net/problem/17135

// 캐슬 디펜스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1. 일단 구현

public class No17135 {

	static int N, M, D;
	static int max = 0;
	static int mat[][];
	static boolean dead[][];
	
	static ArrayList<Integer> archer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		mat = new int[N][M];
		archer = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 조합 3개 고르기
		dfs(0, 0);
		System.out.println(max);
		br.close();
	}

	private static void dfs(int start, int depth) {
		if (depth == 3) {
			check();
			return;
		}

		for (int i = start; i < M; i++) {
			archer.add(i);
			dfs(i + 1, depth + 1);
			archer.remove(depth);
		}
	}

	private static void check() {
		
		dead = new boolean[N][M];
		int count = 0;
		
		// N번 반복해야한다.
		for(int i=0; i<N; i++) {
			
			int min[][]= new int[3][2];
			
			for(int arcidx =0; arcidx<3; arcidx++) {
				int arc = archer.get(arcidx);
				
				min[arcidx] = new int[] {-1, -1};
				min[arcidx] = findMin(arc, i);
			}

			for(int arcidx =0; arcidx<3; arcidx++) {
				if(min[arcidx][0]==-1) continue;
				if(dead[min[arcidx][0]][min[arcidx][1]]) continue;
				
				dead[min[arcidx][0]][min[arcidx][1]] = true;
				count++;
			}
			
		}
		
		max = Math.max(max, count);
		return;
	}

	private static int[] findMin(int arc, int i) {
		int mindis = Integer.MAX_VALUE;
		int minx=-1;
		int miny=-1;
		
		for(int cx=0; cx<N - i; cx++) {
			for(int cy=0; cy<M; cy++) {
				if(mat[cx][cy]!=1) continue;
				if(dead[cx][cy]) continue;
				int dist = Math.abs(N - i - cx) + Math.abs(arc - cy);
				if(dist>D) continue;
				
				if(dist < mindis || (dist == mindis && cy < miny)) {
					mindis = dist;
					minx = cx;
					miny = cy;
				}
					
			}
		}
//		System.out.println(minx + " " + miny);
		return new int[] {minx, miny};
	}
}
