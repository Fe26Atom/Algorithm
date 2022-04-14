package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13460 {
	
	// ���� ������ ���¸� �˷���
	static class Game {
		// ���� �� ��ġ
		int redx, redy;
		// �Ķ� �� ��ġ
		int bluex, bluey;
		// �� �� �����ߴ���
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
	
	// ���ӿ� ���� ��
	static char[][] mat;

	// ���� �׷���
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		
		int rx=-1, ry=-1, bx=-1, by=-1;
		
		// ���� ���� �Ķ� ���� ��ġ�� ���
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
		
		// BFS�� ���� queue
		Queue<Game> queue = new LinkedList<>();
		
		queue.add(new Game(rx, ry, bx, by, 0));
		
		// 0: ���� ��  1: ���� ���� �� �¸�! 2: �Ķ� ���� ��  �й�
		int gamestate = 0;
		int count = -1;
		
		while(!queue.isEmpty()) {
			
			Game cg = queue.poll();
			
			// 10�� Ž���� �ǽ��ߴ�.
			// �ѱ��.
			if(cg.count==10) continue;
			
			// 4�� Ž��
			for(int di=0; di<4; di++) {
				
				// ���� ���� ��Ȳ�� ���
				char[][] cmat = new char[N][M];
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						cmat[i][j] = mat[i][j];
					}
				}
				
//				for(int i=0; i<N; i++) {
//					cmat[i] = mat[i].clone();
//				}
				
				// ���� ���� ��ġ �׷��ֱ�
				cmat[cg.redx][cg.redy] = 'R';
				cmat[cg.bluex][cg.bluey] = 'B';
				
				// ���� ���� ��
				int nrx = cg.redx + dirx[di];
				int nry = cg.redy + diry[di];
				
				// ���� �Ķ� ��
				int nbx = cg.bluex + dirx[di];
				int nby = cg.bluey + diry[di];
				
				// ��ĭ�� ������ ���� �� ����!
				while(cmat[nrx][nry] == '.') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					cmat[nrx][nry] = 'R';
					nrx = nrx + dirx[di];
					nry = nry + diry[di];
				}
				
				// ������ ������ ���� O�ΰ�?
				if(cmat[nrx][nry] == 'O') {
					// �Ķ� ���� ���� �� �ֵ��� �ڸ� ������ֱ�
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					// �ϴ� ���� ���� 1�� �����
					gamestate = 1;
					// ī��Ʈ ����
					count = cg.count + 1;
				}
				
				// ��ĭ�� ������ �Ķ� �� ����!
				while(cmat[nbx][nby] == '.') {
					cmat[nbx - dirx[di]][nby - diry[di]] = '.';
					cmat[nbx][nby] = 'B';
					nbx = nbx + dirx[di];
					nby = nby + diry[di];
				}
				
				// ������ ������ ���� O�ΰ�?
				if(cmat[nbx][nby] == 'O') {
					// �� ���̽��� ���̴�.
					gamestate = 2;
					count = -1;
					// queue�� �ڽĵ��� ���� �ʵ��� ����!
					continue;
				}
				
				// ������ ���� ���� �� �����ΰ�?
				if(gamestate == 1) {
//					System.out.println(di);
//					for(char i[] : cmat) {
//						for(char c : i) {
//							System.out.print(c);
//						}System.out.println();
//					}System.out.println();
					// ������ ã�Ҵ� ������!
					break;
				}
				
				// �ٽ� ���� �� ����!
				while(cmat[nrx][nry] == '.') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					cmat[nrx][nry] = 'R';
					nrx = nrx + dirx[di];
					nry = nry + diry[di];
				}
				
				// ���ΰ�?
				if(cmat[nrx][nry] == 'O') {
					cmat[nrx - dirx[di]][nry - diry[di]] = '.';
					gamestate = 1;
					count = cg.count + 1;
				}
				
				// �ٽ� �Ķ� �� ����!
				while(cmat[nbx][nby] == '.') {
					cmat[nbx - dirx[di]][nby - diry[di]] = '.';
					cmat[nbx][nby] = 'B';
					nbx = nbx + dirx[di];
					nby = nby + diry[di];
				}
				
				// ���ΰ�?
				if(cmat[nbx][nby] == 'O') {
					// �� ���̽��� ���ߴ�!
					gamestate = 2;
					count = -1;
					// �ڽ� �Է� ����
					continue;
				}
				
				if(gamestate == 1) {
//					System.out.println(di);
//					for(char i[] : cmat) {
//						for(char c : i) {
//							System.out.print(c);
//						}System.out.println();
//					}System.out.println();
					// ������ ã�Ҵ� ������!
					break;
				}
				
				// �� �ܰ� ����
				nrx = nrx - dirx[di];
				nry = nry - diry[di];
				
				nbx = nbx - dirx[di];
				nby = nby - diry[di];
				
				// queue�� �־��ֱ�!
				queue.add(new Game(nrx, nry, nbx, nby, cg.count + 1));
				
//				System.out.println(di);
//				for(char i[] : cmat) {
//					for(char c : i) {
//						System.out.print(c);
//					}System.out.println();
//				}System.out.println();
			}
			
			// ������ ������ ������ ã�Ҵ�!
			if(gamestate == 1) break;
		}
		
		// ������ ���, ���� �����̶�� �� ī��Ʈ �ƴ� ��� -1;
		System.out.println(count);
		br.close();
	}
}