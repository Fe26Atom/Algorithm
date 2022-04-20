package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15988 {
	
	static long dp[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new long[1000001];
		
		dp[1]++;
		dp[2]++;
		dp[3]++;
		
		for(int i=0; i<1000001; i++) {
			if(i-1>0) {
				dp[i]= (dp[i-1]+ dp[i]) % 1000000009;
			}
			if(i-2>0) {
				dp[i]= (dp[i-2] + dp[i] ) % 1000000009;
			}
			if(i-3>0) {
				dp[i]= (dp[i-3] + dp[i]) % 1000000009;
			}
		}
		
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n] + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
