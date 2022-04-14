package pdf.ssafy;

public class ws03_막대색칠하기 {
	
	// 파랑 노랑을 더하는 경우 (n-1) * 2
	// 빨강을 더하는 경우 (n-2)
	
	// 즉 f(n) = f(n-1) * 2 + f(n-2)
	
	// dp문제
	
	public static void main(String[] args) {
		int dp[] = new int[7];
				
		dp[0] = 0;
		dp[1] = 2;
		dp[2] = 5; // dp[1] * 2 + 빨강
		
		for(int i=3; i<7; i++) {
			dp[i] = dp[i-1] * 2 + dp[i-2];
		}
		
		System.out.println(dp[6]);
	}
}
