// https://www.acmicpc.net/problem/2610
// ���� �̸� : ȸ�� �غ�
package floid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back2610 {
	
	// 1. ���� �˰� �ִ� ����� �ݵ�� ���� ����ȸ�� ���ؾ� �Ѵ�.
	// 2. ȿ������ ȸ�� ������ ���� ����ȸ�� ���� �ִ밡 �Ǿ�� �Ѵ�.
	
	// 1, 2�� ���ǿ� ���� 1�θ� ����ȸ���� �����ϰ� ���������� ���� �����ؾ��Ѵ�.
	
	// ��ĥ ���θ� ���� ������ Ǯ��� �Ѵ�.
	// ��ǥ ��ȣ�� ���� �� ���ʹϱ� �տ��� ���� ��ĥ�� �����Ѵ�.
	
	// ����� �׷���

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
		
		// �ּ� �Ÿ��� ã�ƾ���
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
