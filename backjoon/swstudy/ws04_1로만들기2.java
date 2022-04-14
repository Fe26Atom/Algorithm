package backjoon.swstudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ws04_1�θ����2 {
	// dp[x/3] + 1 = dp[x]
	// dp[x/2] + 1 = dp[x]
	// dp[x-1] + 1 = dp[x]
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// X �Է�
		int X = sc.nextInt();
		
		// dp[X]�� ����
		int dp[] = new int[X + 1];
		
		// �ʱ�ȭ
		dp[0] = 0;
		dp[1] = 0;

		// dp
		for(int i = 2; i<=X; i++) {
			// dp[x-1] + 1 = dp[x]
			int min = dp[i-1] + 1;
			
			// dp[x/2] + 1 = dp[x]
			if(i%2==0) 
				min = Math.min(min, dp[i/2] + 1);
			
			// dp[x/3] + 1 = dp[x]
			if(i%3==0)
				min = Math.min(min, dp[i/3] + 1);
			// ���� ���� ���� ��
			dp[i] = min;
		}
		System.out.println(dp[X]);
		sc.close();
	}
}
