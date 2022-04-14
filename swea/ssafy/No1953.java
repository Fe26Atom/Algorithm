package swea.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1953 {
	
	
	// bfs문제
	// queue에 넣어서 문제 풀이
	
	// 현재 갈 수 있는 지 없는지를 확인
	
	// queue에서 꺼내서 가능한 방향으로 전진
	// 만약 가는 방향이 모두 방문한 곳이면 정지
	
	
	static int mat[][];
	static boolean visit[][];
	
	static int N;
	static int M;
	static int L;
	
	static int count;
	
	// 상 하 좌 우
	static int dirx[] = {-1, 1, 0, 0};
	static int diry[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			mat = new int[N][M];
			visit = new boolean[N][M];

			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			Queue<int[]> queue = new LinkedList<int[]>();
			
			queue.add(new int[] {R, C, 1});
			count = 1;
			visit[R][C] = true;
			
			while(!queue.isEmpty()) {
				int cx = queue.peek()[0];
				int cy = queue.peek()[1];
				int ccount = queue.peek()[2];
				
				queue.poll();
				
				if(ccount == L) continue;
				
				ArrayList<Integer> dir = new ArrayList<>();
				
				if(mat[cx][cy]== 1 || mat[cx][cy]==2 || mat[cx][cy]==4 || mat[cx][cy]==7)
					dir.add(0);
				if(mat[cx][cy]== 1 || mat[cx][cy]== 2 || mat[cx][cy]== 5 || mat[cx][cy]== 6)
					dir.add(1);
				if(mat[cx][cy]== 1 || mat[cx][cy]== 3 || mat[cx][cy]== 6 || mat[cx][cy]== 7)
					dir.add(2);
				if(mat[cx][cy]== 1 || mat[cx][cy]== 3 || mat[cx][cy]== 4 || mat[cx][cy]== 5)
					dir.add(3);
				
				for(int di : dir) {
//					System.out.println(cx + " " + cy + " " + di);
					int nx = cx + dirx[di];
					int ny = cy + diry[di];
//					System.out.println(nx + " " + ny);
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if(mat[nx][ny]==0) continue;
					if(visit[nx][ny])continue;
					
					boolean cango[] = new boolean[4];
					
					if(mat[nx][ny]== 1 || mat[nx][ny]==2 || mat[nx][ny]==4 || mat[nx][ny]==7)
						cango[1]= true;
					if(mat[nx][ny]== 1 || mat[nx][ny]== 2 || mat[nx][ny]== 5 || mat[nx][ny]== 6)
						cango[0]= true;
					if(mat[nx][ny]== 1 || mat[nx][ny]== 3 || mat[nx][ny]== 6 || mat[nx][ny]== 7)
						cango[3]= true;
					if(mat[nx][ny]== 1 || mat[nx][ny]== 3 || mat[nx][ny]== 4 || mat[nx][ny]== 5)
						cango[2]= true;
					
//					System.out.println(nx + " " + ny + " " + cango[0] + " " + cango[2] + " " + cango[3] + " " + cango[3]);
					if(!cango[di]) continue;
					
					visit[nx][ny] = true;
					queue.add(new int[] {nx, ny, ccount+1});
					count++;
				}
			}
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					if(visit[i][j])
//						System.out.print("1 ");
//					else
//						System.out.print("0 ");
//				}System.out.println();
//			}
//			System.out.println();
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(mat[i][j] + " ");
//				}System.out.println();
//			}
			System.out.println("#" + tc + " " + count);
		}
		br.close();
	}
}
