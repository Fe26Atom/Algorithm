package goohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14503 {
	
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int mat[][] = new int[N][M];
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int di = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {r, c});
		int count = 0;
		
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			
			if(mat[cur[0]][cur[1]] == 0) {
				count++;
				mat[cur[0]][cur[1]] = 2;
			}
			
			for(int didx = 1; didx<=4; didx++) {
				
			}
			
		}
		
	}
}
