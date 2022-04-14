package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13460 {
	
	// 현재 게임의 상태를 알려줌
	static class Game {
		// 빨간 공 위치
		int redx, redy;
		// 파란 공 위치
		int bluex, bluey;
		// 몇 번 수행했는지
		int count;
		public Game(int redx, int redy, int bluex, int bluey, int count) {
			this.redx = redx;
			this.redy = redy;
			this.bluex = bluex;
			this.bluey = bluey;
			this.count = count;
		}
	}
	
	static int N, M;
	
	// 게임에 대한 판
	static char[][] mat;

	// 방향 그래프
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		
		int rx=-1, ry=-1, bx=-1, by=-1;
		
		// 빨간 공과 파란 공은 위치만 기록
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j);
				if(mat[i][j]=='R') {
					rx = i;
					ry = j;
					mat[i][j] = '.';
				}
				if(mat[i][j] == 'B') {
					bx = i;
					by = j;
					mat[i][j] = '.';
				}
			}
		}
		
		// BFS를 위한 queue
		Queue<Game> queue = new LinkedList<>();
		
		queue.add(new Game(rx, ry, bx, by, 0));
		
		// 0: 게임 중  1: 빨간 공만 들어감 승리! 2: 파란 공이 들어감  패배
		int gamestate = 0;
		int count = -1;
		
		while(!queue.isEmpty()) {
			
			Game cg = queue.poll();
			
			// 10번 탐색을 실시했다.
			// 넘긴다.
			if(cg.count==10) continue;
			
			// 4방 탐색
			for(int di=0; di<4; di++) {
				
				// 현재 게임 상황을 기록
				char[][] cmat = new char[N][M];
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						cmat[i][j] = mat[i][j];
					}
				}
				
//				for(int i=0; i<N; i++) {
//					cmat[i] = mat[i].clone();
//				}
				
				// 현재 공들 위치 그려주기
				cmat[cg.redx][cg.redy] = 'R';
				cmat[cg.bluex][cg.bluey] = 'B';
				
				// 다음 빨간 공
				int nrx = cg.redx + dirx[di];
				int nry = cg.redy + diry[di];
				
				// 다음 파란 공
				int nbx = cg.bluex + dirx[di];
				int nby = cg.bluey + diry[di];
				
				// 빈칸일 때까지 빨간 공 전진!
				while(cmat[nrx][nry] == '.') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					cmat[nrx][nry] = 'R';
					nrx = nrx + dirx[di];
					nry = nry + diry[di];
				}
				
				// 다음에 가야할 곳이 O인가?
				if(cmat[nrx][nry] == 'O') {
					// 파란 공이 들어올 수 있도록 자리 만들어주기
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					// 일단 게임 상태 1로 만들기
					gamestate = 1;
					// 카운트 갱신
					count = cg.count + 1;
				}
				
				// 빈칸일 때까지 파란 공 전진!
				while(cmat[nbx][nby] == '.') {
					cmat[nbx - dirx[di]][nby - diry[di]] = '.';
					cmat[nbx][nby] = 'B';
					nbx = nbx + dirx[di];
					nby = nby + diry[di];
				}
				
				// 다음에 가야할 곳이 O인가?
				if(cmat[nbx][nby] == 'O') {
					// 이 케이스는 꽝이다.
					gamestate = 2;
					count = -1;
					// queue에 자식들을 넣지 않도록 생략!
					continue;
				}
				
				// 게임이 빨간 공만 들어간 상태인가?
				if(gamestate == 1) {
//					System.out.println(di);
//					for(char i[] : cmat) {
//						for(char c : i) {
//							System.out.print(c);
//						}System.out.println();
//					}System.out.println();
					// 정답을 찾았다 나가자!
					break;
				}
				
				// 다시 빨간 공 전진!
				while(cmat[nrx][nry] == '.') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					cmat[nrx][nry] = 'R';
					nrx = nrx + dirx[di];
					nry = nry + diry[di];
				}
				
				// 골인가?
				if(cmat[nrx][nry] == 'O') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					gamestate = 1;
					count = cg.count + 1;
				}
				
				// 다시 파란 공 전진!
				while(cmat[nbx][nby] == '.') {
					cmat[nbx - dirx[di]][nby - diry[di]] = '.';
					cmat[nbx][nby] = 'B';
					nbx = nbx + dirx[di];
					nby = nby + diry[di];
				}
				
				// 꽝인가?
				if(cmat[nbx][nby] == 'O') {
					// 이 케이스는 망했다!
					gamestate = 2;
					count = -1;
					// 자식 입력 생략
					continue;
				}
				
				if(gamestate == 1) {
//					System.out.println(di);
//					for(char i[] : cmat) {
//						for(char c : i) {
//							System.out.print(c);
//						}System.out.println();
//					}System.out.println();
					// 정답을 찾았다 나가자!
					break;
				}
				
				// 한 단계 전꺼
				nrx = nrx - dirx[di];
				nry = nry - diry[di];
				
				nbx = nbx - dirx[di];
				nby = nby - diry[di];
				
				// queue에 넣어주기!
				queue.add(new Game(nrx, nry, nbx, nby, cg.count + 1));
				
//				System.out.println(di);
//				for(char i[] : cmat) {
//					for(char c : i) {
//						System.out.print(c);
//					}System.out.println();
//				}System.out.println();
			}
			
			// 게임이 끝났다 정답을 찾았다!
			if(gamestate == 1) break;
		}
		
		// 정답을 출력, 만약 성공이라면 그 카운트 아닐 경우 -1;
		System.out.println(count);
		br.close();
	}
}