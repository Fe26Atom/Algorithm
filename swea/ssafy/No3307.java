package swea.ssafy;

import java.util.Scanner;

public class No3307 {
	
	// ���� ���� �κ� ����
	
	// �κ� ������ ���ϰ�
	// �� �κ� ������ �����ϴ��� Ȯ���϶�?
	
	// dfs�� �κ� �������� �Ի��ϱ⿡�� 1000�� �ִ�.
	
	// dp�� Ǯ�� ����
	
	// �ڿ��� ���� Ǯ���
	
	// �ڿ��� ������ ���鼭 �ڽź��� �ڿ� �ִ� ���� ū �ֿ� count + 1�� ���ش�.
	
	// 1 3 2 5 4
	//         1	// ��� ���� �ڱ� �ڽ��� 1�� ������ ���ش�.
	//       1		// 5�� 4���� ũ��.
	//     2 		// 2�� 5���� �۴�. 5�� 
	//   2
	// 3
	
	
	// 1 3 2 6 4 5
	//           1
	//         2
	//       1
	//     3
	
	// �ڿ��� �̰ͺ��� ū ���� count�� ���� ū �ָ� ã�Ƽ� �־��ش�.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int tc =1; tc<=T; tc++) {
			int max = 0;
			
			int N = sc.nextInt();
			
			int arr[] = new int[N];
			int count[] = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				count[i] = 1;
			}
			
			for(int i=N-1; i>=0; i--) {
				for(int j=i + 1; j<N; j++) {
					if(arr[i] <= arr[j] && count[i] < count[j]+1) {
						count[i] = count[j]+1;
						if(max < count[i]) {
							max = count[i];
							// �ڿ� �ִ� �ֵ� �߿� �ִ븦 ã������ �� �̻� ��ã�Ƶ� �ȴ�.
							break;
						}
					}
				}
			}
//			
//			for(int i : count) {
//				System.out.print(i + " ");
//			}System.out.println();
//			
			sb.append("#" + tc + " " + max+"\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
