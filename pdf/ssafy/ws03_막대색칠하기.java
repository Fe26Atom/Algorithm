package pdf.ssafy;

public class ws03_�����ĥ�ϱ� {
	
	// �Ķ� ����� ���ϴ� ��� (n-1) * 2
	// ������ ���ϴ� ��� (n-2)
	
	// �� f(n) = f(n-1) * 2 + f(n-2)
	
	// dp����
	
	public static void main(String[] args) {
		int dp[] = new int[7];
				
		dp[0] = 0;
		dp[1] = 2;
		dp[2] = 5; // dp[1] * 2 + ����
		
		for(int i=3; i<7; i++) {
			dp[i] = dp[i-1] * 2 + dp[i-2];
		}
		
		System.out.println(dp[6]);
	}
}
