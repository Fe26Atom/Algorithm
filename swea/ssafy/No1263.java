package swea.ssafy;

import java.lang.reflect.Array;
import java.util.Scanner;

public class No1263 {
	
	static int mat[][];
	static int N;
	static boolean visit[];
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {	
			N = sc.nextInt();
			mat = new int[N][N];
			visit = new boolean[N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					mat[i][j] = sc.nextInt();
					
					if(mat[i][j]==0 && i != j)
						mat[i][j] = 1000000000;
				}
			}
			
			int dp[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dp[i][j] = mat[i][j];
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					if(i==k) continue;
					for(int j=0; j<N; j++) {
						if(i==j || k == j) continue;
						if(dp[i][k] + dp[k][j] < dp[i][j]) {
							dp[i][j] = dp[i][k] + dp[k][j];
						}
					}
				}
			}
			int min = Integer.MAX_VALUE;
			
			for(int i=0;i<N; i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					sum += mat[i][j];
				}
				min = Math.min(min, sum);
			}
			
			sb.append("#" + tc + " " + min);
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

	
}
