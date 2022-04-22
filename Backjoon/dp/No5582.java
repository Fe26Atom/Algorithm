package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5582 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();

		int alen = a.length();
		int blen = b.length();

		int dp[][] = new int[alen + 1][blen + 1];
 
		int result = 0;
		
		for(int i=1; i<=alen; i++) {
			for(int j=1; j<=blen; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				
				result = result < dp[i][j] ? dp[i][j] : result;
			}
		}
				
		System.out.println(result);
		br.close();
	}
}
