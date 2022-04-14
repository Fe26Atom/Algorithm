package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No4485 {
	
	//dp 최솟갑 문제
	
	//가는 방향 마다 최솟값 갱신

	// queue에 이동 할 수 있는 것을 해주고 거기에 최솟값을 계속 갱신해준다.
	
	// 코스트 배열
	// dp 배열
	
	// 이동 방향
	
	// dp가 갱신할 때 queue에 넣기
	
	// visit를 챙기지 않는다.
	
	
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(N!=0) {
			count++;
			int cost[][] = new int[N][N];
			int dp[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				Arrays.fill(dp[i], Integer.MAX_VALUE);
				for(int j=0; j<N; j++) {
					cost[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<int[]>queue = new LinkedList<int[]>();
			queue.add(new int[] {0, 0});
			dp[0][0] = cost[0][0];
			
			while(!queue.isEmpty()) {
				int cx = queue.peek()[0];
				int cy = queue.peek()[1];
				queue.poll();
				
				for(int di=0; di<4; di++) {
					int nx = cx + dirx[di];
					int ny = cy + diry[di];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					
					if(dp[cx][cy] + cost[nx][ny] < dp[nx][ny]) {
						dp[nx][ny] = dp[cx][cy] + cost[nx][ny];
						queue.add(new int[] {nx, ny});
					}
//					System.out.println(cx + " " + cy + " " + dp[cx][cy]);
//					System.out.println(nx + " " + ny + " " + dp[nx][ny]);
					
				}
			}
			System.out.println("Problem " + count + ": " + dp[N-1][N-1]);
			
			N = Integer.parseInt(br.readLine());
		}
	}
}
