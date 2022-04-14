package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2636 {
	// bfs 
	
	// 토마토랑 같이 풀 것
	
	// 공기 접촉 치즈 
	// 공기 미접촉 치즈 
	
	// 처음 시작시 공기 접촉 여부를 체크한다.
	// queue를 이동해서 체크?
	
	// 공기 접촉 치즈를 queue에 넣기
	// queue에서 꺼내서 없애기-> 없애면서 주변에 치즈를 3으로 바꾸기
	// 만약 f치즈가 t치즈가 되면 새로운 queue에 넣어주기
	// queue가 빌때까지 
	
	// queue가 다 떨어지면 새 queue로 바꿔주기
	// size는 계속 갱신
	// 마지막 사이즈가 정답
	// 깊이도 측정.
	
	static int dirx[] = {-1,0,1,0};
	static int diry[] = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h= Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int mat[][] = new int[h][w];
		int air[][] = new int[h][w];
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		bfs를 위한 queue
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// 공기중 접촉 
		for(int i=0; i<h; i++) {
			queue.add(new int[] {0,i});
		}
		
		for(int i=0; i<w; i++) {
			queue.add(new int[] {i,0});
		}
		
		// 공기 접촉 여부 체크
		
		// 공기 접촉 치즈 체크를 위한 queue
		Queue<int[]> nq = new LinkedList<int[]>();
		int size = queue.size();
		int depth = 0;
		
		while(!queue.isEmpty()) {			
			int[] cur = queue.poll();
			
			for(int di=0; di<4; di++) {
				int nx = cur[0]+dirx[di];
				int ny = cur[1]+diry[di];
				
				if(nx<0 || ny<0 || nx >= h || ny >= w) continue;
				
				if(mat[nx][ny]!= -1 ) {
					// 치즈면 다음 queue에 넣기
					if(mat[nx][ny]== 1 )
						nq.add(new int[] {nx, ny});
					// 공기면 지금 queue에 넣기
					else
						queue.add(new int[] {nx, ny});
					mat[nx][ny]= -1;
				}
			}
			
			if(queue.size()==0) {
				if(nq.size()==0) break;
				
				depth++;
				size = nq.size();
				queue = nq;
				nq = new LinkedList<>();
			}
		}
		System.out.println(depth);
		System.out.println(size);
		
		br.close();
	}
}
