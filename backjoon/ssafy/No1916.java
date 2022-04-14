package backjoon.ssafy;

import java.util.Scanner;

public class No1916 {
	
	static int N;
	static int arr[][];
	static int dist[];
	static boolean visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N][N];
		dist = new int[N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				arr[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;
			int w = sc.nextInt();
			arr[s][e] = w;
		}
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			dist[i]= arr[start - 1][i];
		}
		
		visit[start] = true;
		
		for(int i=0; i<N; i++) {
			int cur = getMinIdx();
			visit[cur] = true;
			for(int j=0; j<N; j++) {
				if(!visit[j]) {
					if(dist[cur] + arr[cur][j] < dist[j]) {
						dist[j] = dist[cur] + arr[cur][j];
					}
				}
			}
		}
		
//		for(int i : dist) {
//			System.out.print(i + " ");
//		}System.out.println();
		
		System.out.println(dist[end-1]);
		sc.close();
	}

	private static int getMinIdx() {
		long min = Integer.MAX_VALUE;
		int idx = 0;
		
		for(int i=0; i<N; i++) {
			if(dist[i] < min && !visit[i]) {
				min = dist[i];
				idx = i;
			}
		}
		return idx;
	}
}
