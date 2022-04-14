//https://www.acmicpc.net/problem/11404
// 문제 이름 : 플로이드
package floid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back11404 {
	static final int INF = 1000000000;
	// 플로이드 워샬 문제
	
	// 인접 리스트로 문제 풀어보기
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 도시 갯수
		int N = Integer.parseInt(br.readLine());
		
		// 버스 갯수
		int M = Integer.parseInt(br.readLine());
		
		// 도시끼리 가는 비용을 적는 그래프
		int arr[][] = new int [N][N];
		
		// 모든 도시의 가는 길을 INF로 채움
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], INF);
			arr[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 출발 도시
			int s = Integer.parseInt(st.nextToken()) - 1;
			// 도착 도시
			int e = Integer.parseInt(st.nextToken()) - 1;
			// 비용
			int w = Integer.parseInt(st.nextToken());
			if(arr[s][e] > w)
				arr[s][e] = w;
		}
		
		// 플로이드 워샬 알고리즘
		// k는 경유지
		for(int k=0; k<N; k++) {
			// i는 출발지
			for(int i=0; i<N; i++) {
				// j는 도착지
				for(int j=0; j<N; j++) {
					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] >= INF)
					arr[i][j] = 0;
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		
		br.close();
	}
}
