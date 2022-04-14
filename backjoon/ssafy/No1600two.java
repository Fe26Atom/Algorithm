package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1600two {
	
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	static int hdirx[] = {-2, -2, 2, 2, -1, -1, 1, 1};
	static int hdiry[] = {-1, 1, -1, 1, -2, 2, -2, 2};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int mat[][] = new int [H][W];
		boolean visit[][][] = new boolean [H][W][K+1];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0,0,0,0});
		visit[0][0][0] = true;
		
		int num = -1;
		
		while(!queue.isEmpty()) {
			int cx = queue.peek()[0];
			int cy = queue.peek()[1];
			int count = queue.peek()[2];
			int depth = queue.peek()[3];
			queue.poll();
			
			if(cx== W-1 && cy == H-1) {
				num = depth;
				break;
			}
			
			for(int di=0; di<4; di++) {
				int nx = cx + dirx[di];
				int ny = cy + diry[di];
				
				if(nx<0 || ny <0 || nx>=H || ny>=W) continue;
				
				if(mat[nx][ny] == 1) continue;
				if(visit[nx][ny][count]) continue;
				
				visit[nx][ny][count] = true;
				queue.add(new int[] {nx, ny, count, depth + 1});
			}
			
			for(int di=0; di<8; di++) {
				if(count==K) break;
				
				int nx = cx + hdirx[di];
				int ny = cy + hdiry[di];

				if(nx<0 || ny <0 || nx>=H || ny>=W) continue;
				
				if(mat[nx][ny] == 1) continue;
				if(visit[nx][ny][count + 1]) continue;
				

				visit[nx][ny][count + 1] = true;
				queue.add(new int[] {nx, ny, count+1, depth + 1});
			}
		}
		System.out.println(num);
		br.close();
	}
}
