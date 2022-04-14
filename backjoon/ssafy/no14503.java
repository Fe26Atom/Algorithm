package backjoon.ssafy;
// https://www.acmicpc.net/problem/14503
// 로봇 청소기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14503 {
	
	// d가 방향 북, 동, 남, 서
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, 1, 0, -1};
	
	static int mat[][];
	
	static int N,M,r,c,d,clean;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		
		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean = 0;
		
		// 로봇 청소기 작동
		move();
		
		System.out.println(clean);
	}

	private static void move() {
//		System.out.println(r + " " + c);
		// 이동한 곳이 청소한 곳이 아니라면
		if(mat[r][c]==0) {
			// 청소
			mat[r][c] = 2;
			clean++;
		}
		
		boolean flag = false;
		
		for(int i=0; i<4; i++) {
			d = (d + 3) % 4;
			int nr = r + dirx[d];
			int nc = c + diry[d];
			
			if(mat[nr][nc] == 0) {
				r=nr;
				c=nc;
				move();
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			//4곳이 다 벽이거나 청소한 곳이면 뒤로 후진 여부 체크
			int nr = r - dirx[d];
			int nc = c - diry[d];
			
			// 후진하는 곳이 빈칸이면 후진
			if(mat[nr][nc] != 1) {
				r = nr;
				c = nc;
				move();
			}
			
			// 후진하는 곳이 벽이면 작동 중지
			else
				return;
		}
	}
}
