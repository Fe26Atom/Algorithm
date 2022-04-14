//https://www.acmicpc.net/problem/2458
// 문제 이름  : 키 순서

package floid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back2458 {
	
	// 플로이드로 부모 찾기
	// 플로이드로 자식 찾기
	static final int INF = 10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int parent[][] = new int [N][N];
		int son[][] = new int [N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(parent[i], INF);
			Arrays.fill(son[i], INF);
			parent[i][i] = 0;
			son[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			parent[a][b] = 1;
			son[b][a] = 1;
		}
		
		// 플루이드 워샬
		for(int k=0; k<N; k++) {
			
			for(int i=0; i<N; i++) {
				
				for(int j=0; j<N; j++) {
					
					if(parent[i][j] > parent[i][k] + parent[k][j]) {
						parent[i][j] = parent[i][k] + parent[k][j];
					}
					
					if(son[i][j] > son[i][k] + son[k][j]) {
						son[i][j] = son[i][k] + son[k][j];
					}
					
				}
			}
		}
		
		int count = 0;
		
		for(int i=0; i<N; i++) {
			boolean isInf = false;
			for(int j=0; j<N; j++) {
				if(parent[i][j]==INF && son[i][j]==INF) {
					isInf = true;
					break;
				}
			}
			if(!isInf) count++;
		}
		System.out.println(count);
	}
}
