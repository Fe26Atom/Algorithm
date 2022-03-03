package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13460 {
	
	static class Game {
		int redx, redy;
		int bluex, bluey;
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
	
	static char[][] mat;
	
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		
		int rx=-1, ry=-1, bx=-1, by=-1;
		
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
		
		Queue<Game> queue = new LinkedList<>();
		
		queue.add(new Game(rx, ry, bx, by, 0));
		
		
		int gamestate = 0;
		int count = -1;
		
		while(!queue.isEmpty()) {
			
			Game cg = queue.poll();
			
			if(cg.count==10) break;
			
			for(int di=0; di<4; di++) {
				
				char[][] cmat = new char[N][M];
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						cmat[i][j] = mat[i][j];
					}
				}
				
				cmat[cg.redx][cg.redy] = 'R';
				cmat[cg.bluex][cg.bluey] = 'B';
				
				
				int nrx = cg.redx + dirx[di];
				int nry = cg.redy + diry[di];
				
				int nbx = cg.bluex + dirx[di];
				int nby = cg.bluey + diry[di];
				
				while(cmat[nrx][nry] == '.') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					cmat[nrx][nry] = 'R';
					nrx = nrx + dirx[di];
					nry = nry + diry[di];
				}
				
				if(cmat[nrx][nry] == 'O') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					gamestate = 1;
					count = cg.count + 1;
				}
				
				while(cmat[nbx][nby] == '.') {
					cmat[nbx - dirx[di]][nby - diry[di]] = '.';
					cmat[nbx][nby] = 'B';
					nbx = nbx + dirx[di];
					nby = nby + diry[di];
				}
				
				if(cmat[nbx][nby] == 'O') {
					cmat[nbx - dirx[di]][nby - diry[di]] = '.';
					gamestate = 2;
					count = -1;
					continue;
				}
				
				if(gamestate == 1) {
//					System.out.println(di);
//					for(char i[] : cmat) {
//						for(char c : i) {
//							System.out.print(c);
//						}System.out.println();
//					}System.out.println();
					break;
				}
				
				while(cmat[nrx][nry] == '.') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					cmat[nrx][nry] = 'R';
					nrx = nrx + dirx[di];
					nry = nry + diry[di];
				}
				
				if(cmat[nrx][nry] == 'O') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					gamestate = 1;
					count = cg.count + 1;
				}
				
				while(cmat[nbx][nby] == '.') {
					cmat[nbx - dirx[di]][nby - diry[di]] = '.';
					cmat[nbx][nby] = 'B';
					nbx = nbx + dirx[di];
					nby = nby + diry[di];
				}
				
				if(cmat[nbx][nby] == 'O') {
					cmat[nbx - dirx[di]][nby - diry[di]] = '.';
					gamestate = 2;
					count = -1;
					continue;
				}
				
				nrx = nrx - dirx[di];
				nry = nry - diry[di];
				
				nbx = nbx - dirx[di];
				nby = nby - diry[di];
				
				queue.add(new Game(nrx, nry, nbx, nby, cg.count + 1));
				
//				System.out.println(di);
//				for(char i[] : cmat) {
//					for(char c : i) {
//						System.out.print(c);
//					}System.out.println();
//				}System.out.println();
			}
			
			if(gamestate == 1) break;
		}
		
		System.out.println(count);
		br.close();
	}
}