package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13398 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int dp[][] = new int[N][2];
		int arr[] = new int[N];
		
		for(int i=0; i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		int max = arr[0];
		
		for(int i=0; i<N;i++) {
			dp[i][0] = dp[i][1] = arr[i];
			if(i==0) continue;
			dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		System.out.println(max);
		br.close();
 	}
}
