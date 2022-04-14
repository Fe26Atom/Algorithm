package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No8320 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[N + 1];
		int arr[] = new int[N + 1];
		for(int i=1; i<=N; i++) {
			arr[i] = squares(i);
			dp[i] = dp[i-1] + arr[i];
		}
		System.out.println(dp[N]);
		br.close();
	}

	private static int squares(int num) {
		int count = 0;
		
		for(int i=1; i <= Math.sqrt(num); i++) {
			if(num % i == 0) count++;
		}
		
		return count;
	}
}
