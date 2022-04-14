package swea.ssafy;

import java.util.Scanner;

public class No3307 {
	
	// 최장 증가 부분 수열
	
	// 부분 수열을 구하고
	// 그 부분 수열이 증가하는지 확인하라?
	
	// dfs로 부분 수열들을 게산하기에는 1000이 있다.
	
	// dp로 풀어 보자
	
	// 뒤에서 부터 풀어보기
	
	// 뒤에서 앞으로 가면서 자신보다 뒤에 있는 애중 큰 애에 count + 1을 해준다.
	
	// 1 3 2 5 4
	//         1	// 모든 수는 자기 자신을 1의 개수를 세준다.
	//       1		// 5는 4보다 크다.
	//     2 		// 2는 5보다 작다. 5는 
	//   2
	// 3
	
	
	// 1 3 2 6 4 5
	//           1
	//         2
	//       1
	//     3
	
	// 뒤에서 이것보다 큰 애중 count가 가장 큰 애를 찾아서 넣어준다.
	
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
							// 뒤에 있는 애들 중에 최대를 찾았으니 더 이상 안찾아도 된다.
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
