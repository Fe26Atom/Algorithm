package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ws5656_벽돌깨기 {
	
	static int mat[][];
	static int N, W, H;
	static int max = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			// 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			mat = new int[H][W];
			max = 0;
			
			int count = 0;
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
					if(mat[i][j] != 0) count++;
				}
			}
			// 입력 끝
			// dfs를 이용하여
			// 모든 경우의 공이 쏴진 경우를 비교한다.
			
			dfs(0,0);
			System.out.println(count + " " + max);
			System.out.println("#" + tc + " " + (count - max));
		}
		
		br.close();
	}

	private static void dfs(int depth, int cnt) {
		// N번 공을 쏜 거라면 비교!
		if(depth == N) {
			System.out.println(cnt);
			max = max < cnt ? cnt : max;
			return;
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		int imsimat[][] = new int[H][W];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				imsimat[i][j] = mat[i][j];
			}
		}
		
		
		for(int i=0; i<W; i++) {
			int idx = 0;
			int count =0;
			
			while( idx < N &&mat[idx][i]==0) {
				idx++;
			}
			// 빈 줄일 경우
			if(idx == N)
				continue;
			System.out.println(idx + " " + i);
			
			mat[idx][i] = 0;
			queue.add(new int[] {idx, i, mat[idx][i]});
			
			while(!queue.isEmpty()) {
				count++;
				int ch = queue.peek()[0];
				int cw = queue.peek()[1];
				int len = queue.peek()[2]-1;
				queue.poll();
				
				for(int w=cw - len; w<=cw + len; w++) {
					if(w<0) continue;
					if(w>=N) continue;
					if(mat[ch][w] != 0) {
						mat[ch][w] = 0;
						queue.add(new int[] {ch, w, mat[ch][w]});
					}
				}
				
				for(int h= ch; h<= h + len; h++) {
					if(h>=N) continue;
					if(mat[h][cw] != 0) {
						mat[h][cw] = 0;
						queue.add(new int[] {h, cw, mat[h][cw]});
					}
				}
			}
			System.out.println("c : " + count);
			
			for(int h=0; h<H; h++) {
				for(int w=0; w<W; w++) {
					System.out.print(mat[h][w] + " ");
				}System.out.println();
			}
			
			System.out.println();
			
			// 밑으로 다 밀어주기
			
			for(int w = 0; w<W; w++) {
				int arridx = 0;
				
				for(int h= H-1; h>=0; h--) {
					if(mat[h][w]!=0) {
						mat[arridx++][w] = mat[h][w];
						mat[h][w] = 0;
					}
				}
			}
			
			for(int h=0; h<H; h++) {
				for(int w=0; w<W; w++) {
					System.out.print(mat[h][w] + " ");
				}System.out.println();
			}
			
			dfs(depth+1, cnt + count);
			
			// 다시 원상 복구 해주기
			for(int h=0; h<H; h++) {
				for(int w=0; w<W; w++) {
					mat[h][w] = imsimat[h][w];
				}
			}
		}
	}
}
