package swea.ssafy;

import java.util.ArrayList;
import java.util.Scanner;

public class No1767 {
	
	//dfs
	// 각 셀 마다 4방 탐색
	
	static int N;
	
	static int maxCell = 0;
	static int minLen = Integer.MAX_VALUE;
	
	static int mat[][];
	static ArrayList<int[]> cellList;
	
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T= sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			maxCell = 0;
			minLen = Integer.MAX_VALUE;
			
			N = sc.nextInt();
			
			mat = new int[N][N];
			cellList = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					mat[i][j] = sc.nextInt();
					if(mat[i][j]==1)
						cellList.add(new int[] {i, j});
				}
			}
			
			dfs(0, 0, 0);
			
			sb.append("#"+tc + " " + minLen+"\n");
		}
		System.out.println(sb);
		sc.close();
	}

	private static void dfs(int depth, int len, int count) {
		if(depth == cellList.size()) {
			if(maxCell < count) {
				maxCell = count;
				minLen = len;
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						System.out.print(mat[i][j] + " ");
					}System.out.println();
				}
				System.out.println(maxCell + " " + minLen);
				
			}
			else if(maxCell == count) {
				minLen = Math.min(minLen, len);
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						System.out.print(mat[i][j] + " ");
					}System.out.println();
				}
				System.out.println(maxCell + " " + minLen);
			}
			return;
		}
		
		// 4방 중에 몇 개 가능한지 찾기
		int dircount = 0;

		int cx = cellList.get(depth)[0];
		int cy = cellList.get(depth)[1];
		
		
		//4방으로 검색
		for(int di=0; di<4; di++) {
			int lenC = 0;
			int nx = cx;
			int ny = cy;
			
			while(nx!=0 && ny!=0 && nx!=N-1 && ny != N-1) {
				nx += dirx[di];
				ny += diry[di];
				
				if(mat[nx][ny]!=0) {
					lenC = 0;
					break;
				}
				mat[nx][ny]=2;
				lenC++;
			}
			
			if(lenC > 0) {
				dircount++;
				dfs(depth+1, len + lenC, count + 1);
			}
			
			nx = cx;
			ny = cy;
			
			while(nx!=0 && ny!=0 && nx!=N-1 && ny != N-1) {
				nx += dirx[di];
				ny += diry[di];
				
				if(mat[nx][ny]!=0) {
					break;
				}
				mat[nx][ny]=0;
			}
		}
		
		if(dircount==0) {
			dfs(depth+1, len, count);
		}
	}
}