//https://www.acmicpc.net/problem/12738
// 가장 긴 증가하는 부분 수열
package backjoon.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No12738 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0]=arr[0];
		
		int size = 1;
		
		for(int i=1; i<N; i++) {
			int temp = Arrays.binarySearch(dp, 0, size,  arr[i]);
			if(temp < 0) temp = temp * -1 -1;
//			System.out.println(arr[i] + " " + temp);
			dp[temp] = arr[i];
			
			if(size == temp) {
				size++;
			}
		}
		System.out.println(size);
	}
}
