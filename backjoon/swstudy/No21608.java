package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No21608 {
	static boolean used[];
	static int mat[][];
	static int count[][];
	static int info[][];
	
	static int dirx[] = {-1,0,1,0};
	static int diry[] = {0,-1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		used = new boolean[N * N + 1];
		info = new int[N * N + 1][2];
		
		mat = new int[N][N];
		
		count = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int num = 0;
				for(int di=0; di<4; di++) {
					int nx = i + dirx[di];
					int ny = j + diry[di];
					
					if(nx<0 || ny<0 || nx >= N || ny >= N) continue;
					num++;
				}
				count[i][j] = num;
			}
		}
		
		for(int c=0; c<N*N; c++) {
			ArrayList<int[]> arr = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			System.out.println(n);
			for(int i=0; i<4; i++) {
				int s= Integer.parseInt(st.nextToken());
				System.out.print(s + " : ");
				if(used[s]) {
					int cx = info[s][0];
					int cy = info[s][1];
					System.out.print(cx + " " + cy + " ");
					for(int di=0; di<4; di++) {
						int nx = cx + dirx[di];
						int ny = cy + diry[di];
						
						if(nx<0 || ny<0 || nx >= N || ny >= N) continue;
						if(mat[nx][ny]!=0) continue;
						arr.add(new int[] {nx, ny});
					}
				}
				System.out.println();
			}
			
			if(arr.size()==0) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(mat[i][j]==0) {
							arr.add(new int[] {i, j});
						}
					}
				}
			}
			
			arr.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(count[o1[0]][o1[1]] == count[o2[0]][o2[1]]){
						if(o1[0]==o2[0])
							return o1[1]- o2[1];
						return o1[0]- o2[0];
					}
					return count[o2[0]][o2[1]] - count[o1[0]][o1[1]];
				}
			});
			
			int cx = arr.get(0)[0];
			int cy = arr.get(0)[1];
			
			mat[cx][cy] = n;
			used[n] = true;
			info[n][0] = cx;
			info[n][1] = cy;
			
			for(int di=0; di<4; di++) {
				int nx = cx + dirx[di];
				int ny = cy + diry[di];
				if(nx<0 || ny<0 || nx >= N || ny >= N) continue;
				count[nx][ny]--;
			}
			for(int i[] : mat) {
				for(int j:i) {
					System.out.print(j + " ");
				}System.out.println();
			}
		}
		for(int i[] : mat) {
			for(int j:i) {
				System.out.print(j + " ");
			}System.out.println();
		}
	}
}
