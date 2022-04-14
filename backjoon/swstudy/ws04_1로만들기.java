package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ws04_1로만들기 {
	// dp[x/3] = dp[x] + 1
	// dp[x/2] = dp[x] + 1
	// dp[x-1] = dp[x] + 1
	
	// 뒤에서 앞으로 가는 dp
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		int dp[] = new int[X + 1];
		
		dp[X] = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(X);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(cur==1) break;
			
			if(cur%3 == 0 && dp[cur/3]==0) {
				dp[cur/3] = dp[cur] + 1;
				queue.add(cur/3);
			}
			if(cur%2 == 0 && dp[cur/2]==0) {
				dp[cur/2] = dp[cur] + 1;
				queue.add(cur/2);
			}
			if(dp[cur-1]==0) {
				dp[cur-1] = dp[cur] + 1;
				queue.add(cur-1);
			}
		}
		System.out.println(dp[1]);
		br.close();
	}
}
