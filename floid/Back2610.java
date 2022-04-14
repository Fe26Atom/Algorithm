// https://www.acmicpc.net/problem/2610
// 문제 이름 : 회의 준비
package floid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back2610 {
	
	// 1. 서로 알고 있는 사람은 반드시 같은 위원회에 속해야 한다.
	// 2. 효율적인 회의 진행을 위해 위원회의 수는 최대가 되어야 한다.
	
	// 1, 2의 조건에 의해 1로만 위원회들을 구성하고 나머지들은 따로 구성해야한다.
	
	// 색칠 여부를 보고 문제를 풀어야 한다.
	// 대표 번호가 작은 수 부터니까 앞에서 부터 색칠을 시작한다.
	
	// 양방향 그래프

	static final int INF = 1000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int mat[][] = new int[N][N + 1];
		boolean visit[] = new boolean[N];
		
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> committee = new ArrayList<>();
		
		for(int i=0; i<N;i++) {
			Arrays.fill(mat[i], INF);
			mat[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			mat[a][b] = 1;
			mat[b][a] = 1;
		}
		
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(mat[i][j] > mat[i][k] + mat[k][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<=N; j++) {
				if(mat[i][j]==INF) mat[i][j] = 0;
			}
		}
		
		// 최소 거리를 찾아야함
		for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				mat[i][N] = Math.max(mat[i][j], mat[i][N]);
			}
		}
	
		
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			
			int min = i;
			visit[i] = true;
			
			for(int j=i+1; j<N; j++) {
				if(visit[j]) continue;
				if(mat[i][j]==0) continue;
				visit[j] = true;
				if(mat[min][N] > mat[j][N]) {
					min = j;
				}
			}
			committee.add(min);
		}
		
		Collections.sort(committee);
		
		System.out.println(committee.size());
		for(int i : committee) {
			System.out.println(i + 1);
		}
		
		br.close();
	}
}
