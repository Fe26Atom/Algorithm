package backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16197 {

	static int N, M;
	
	static int coins[];
	static char mat[][];
	static boolean visit[][][][];
	
	static int dirx[] = {-1,0,1,0};
	static int diry[] = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int idx = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		coins = new int[4];
		visit = new boolean[N][M][N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j);
				
				if(mat[i][j] == 'o') {
					coins[idx * 2] = i;
					coins[idx * 2 + 1] = j;
					idx++;
				}
			}
		}
		
		System.out.println(dfs());
	}

	private static int dfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0, coins[0], coins[1], coins[2], coins[3]});
		visit[coins[0]][coins[1]][coins[2]][coins[3]] = true;
		
		while(!queue.isEmpty()) {
			int depth = queue.peek()[0];
			int ax = queue.peek()[1];
			int ay = queue.peek()[2];
			int bx = queue.peek()[3];
			int by = queue.peek()[4];
			queue.poll();
			
//			System.out.println(depth + " " + ax + " "+ ay + " " + bx + " "+ by);
			
			if(depth >= 10) break;
			
			for(int di = 0; di < 4; di++) {
				int nax = ax + dirx[di];
				int nay = ay + diry[di];
				int nbx = bx + dirx[di];
				int nby = by + diry[di];
				
				boolean ca = check(nax, nay);
				boolean cb = check(nbx, nby);
				
//				System.out.println(depth + " " + nax + " "+ nay + " " + nbx + " "+ nby + " " + ca + " " + cb );
				
				if(!ca) {
					if(mat[nax][nay] == '#') {
						nax = ax;
						nay = ay;
					}
				}
				if(!cb) {
					if(mat[nbx][nby] == '#') {
						nbx = bx;
						nby = by;
					}
				}
				
				if(ca && cb) {
					continue;
				}
				
				if(ca || cb) {
//					System.out.println(depth + " " + nax + " "+ nay + " " + nbx + " "+ nby + " " + ca + " " + cb );
					return depth + 1;
				}
				
				if(visit[nax][nay][nbx][nby]) continue;
				
				if(nax == nbx && nay == nby) continue;
				
				visit[nax][nay][nbx][nby] = true;
				queue.add(new int[] {depth + 1, nax, nay, nbx, nby});
			}
		}
		
		return -1;
	}

	private static boolean check(int nx, int ny) {
		if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
			return true;
		}
		return false;
	}
}