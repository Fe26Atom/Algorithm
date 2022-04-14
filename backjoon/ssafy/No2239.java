package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No2239 {
	
	// 백트래킹 문제
	// 0에는 1~9가 들어간다.
	// 3 by 3에서 체크
	// 가로, 세로 체크
	// 아닐 경우 나가기
	
	static int mat[][] = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	static String answer = "999";
	static ArrayList<int[]> zeros = new ArrayList<int[]>();
	
	static int size;
	
	static boolean threeby[][][] = new boolean[3][3][10];
	static boolean wused[][] = new boolean[9][10];
	static boolean hused[][] = new boolean[9][10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			String line = br.readLine();
			
			for(int j=0; j<9; j++) {
				mat[i][j] = line.charAt(j) - '0';
				
				if(mat[i][j]==0) {
					zeros.add(new int[] {i, j});
				}
				
				threeby[i/3][j/3][mat[i][j]] = true;
				wused[i][mat[i][j]] = true;
				hused[j][mat[i][j]] = true;
			}
		}
		
		size = zeros.size();
		
		dfs(0);
		System.out.println(answer);
	}

	private static boolean dfs(int depth) {
		
		if(depth == size) {
			String ans = "";
			for(int line[] : mat) {
				for(int i : line) {
					ans += i;
				}ans += "\n";
			}
			if(answer.compareTo(ans) > 0) {
				answer = ans;
			}
//			System.out.println(answer);
			return true;
		}
		
		int x = zeros.get(depth)[0];
		int y = zeros.get(depth)[1];
		
		for(int i=1; i<=9; i++) {
			if(threeby[x/3][y/3][i]) continue;
			if(wused[x][i]) continue;
			if(hused[y][i]) continue;
			
			threeby[x/3][y/3][i] = true;
			wused[x][i] = true;
			hused[y][i] = true;
			
			mat[x][y] = i;
			if(dfs(depth + 1)) {
				return true;
			}
			mat[x][y] = 0;
			
			threeby[x/3][y/3][i] = false;
			wused[x][i] = false;
			hused[y][i] = false;
		}
		return false;
	}
}
