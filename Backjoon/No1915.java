package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1915 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[][] = new int[n][m];
		int dp[][] = new int[n][m];
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		for(int i=0; i<n; i++) {
			dp[i][0] = arr[i][0];
			max = Math.max(dp[i][0], max);
		}
		for(int j=0; j<m; j++) {
			dp[0][j] = arr[0][j];
			max = Math.max(dp[0][j], max);
		}

		
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				if(arr[i][j] == 0) continue; 
				dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
				max = Math.max(dp[i][j], max);
			}
		}
		System.out.println(max * max);
		br.close();
	}
}
