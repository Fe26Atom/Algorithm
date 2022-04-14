package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1600 {
	// 백트래킹 문제?
	// bfs문제?
	// 가장 적게라고 헀으니 bfs가 맞는 것 같은데?
	
	// depth가 가장 적은것을 찾으면 되는거 같은데
	
	// 만약 도달 못하면 -1

	static int dirx[] = {-1, 0, 1, 0, 2, 2, -2, -2, 1, 1, -1, -1};
	static int diry[] = {0, -1, 0, 1, 1, -1, 1, -1, 2, -2, 2, -2};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int mat[][] = new int[h][w];
		boolean visit[][][] = new boolean[h][w][K + 1];
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// x, y, used, depth
		queue.add(new int[] {0,0,0,0});
		visit[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			
			int cx = queue.peek()[0];
			int cy = queue.peek()[1];
			int used = queue.peek()[2];
			int depth = queue.peek()[3];
			queue.poll();
			
			if(cx==h-1 && cy==w-1) {
				System.out.println(depth);
				br.close();
				return;
			}
			
			for(int di=0; di<12; di++) {
				if(di == 4 && used == K) break;
				
				int nx = cx + dirx[di];
				int ny = cy + diry[di];
				
				if(nx<0 || ny <0 || nx >=h || ny >=w) continue;
				
				if(di>=4) {
					if(mat[nx][ny]==1 || visit[nx][ny][used+1]) continue;
					visit[nx][ny][used + 1] = true;
					queue.add(new int[] {nx, ny, used+1, depth+1});
				}
				else {
					if(mat[nx][ny]==1 || visit[nx][ny][used]) continue;
					visit[nx][ny][used] = true;
					queue.add(new int[] {nx, ny, used, depth+1});
				}
			}
		}
		System.out.println(-1);
		br.close();
	}
}
