package backjoon.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dp

// 자신의 앞에 것을 기억하고 있으면 된다.

// 자기보다 작은 애 중 가장 큰 길이를 가지고 있는 애를 찾는다.

public class No14002 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		int dp[] = new int[N];
		int parent[] = new int[N];
		
		// 자기 자신을 가지고 있으니 길이는 1이상이다.
		Arrays.fill(dp, 1);
		
		// 부모(앞의 수)를 -1(없음)으로 초기화
		Arrays.fill(parent, -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최장 길이를 저장
		int max = 1;
		
		// 최장 길이의 마지막 위치
		int maxLast = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					parent[i] = j;
				}
				if(dp[i] > max) {
					// 최장 길이 갱신, 최장 길이 마지막 위치 갱신
					max = dp[i];
					maxLast = i;
				}
			}
		}
		
		System.out.println(max);
		String ans = "";
		
		for(int i=0; i<max; i++) {
			ans = arr[maxLast] + " " + ans;
			maxLast = parent[maxLast];
		}
		System.out.println(ans);
		br.close();
	}
}
