//https://www.acmicpc.net/problem/11404
// ���� �̸� : �÷��̵�
package floid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back11404 {
	static final int INF = 1000000000;
	// �÷��̵� ���� ����
	
	// ���� ����Ʈ�� ���� Ǯ���
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� ����
		int N = Integer.parseInt(br.readLine());
		
		// ���� ����
		int M = Integer.parseInt(br.readLine());
		
		// ���ó��� ���� ����� ���� �׷���
		int arr[][] = new int [N][N];
		
		// ��� ������ ���� ���� INF�� ä��
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], INF);
			arr[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// ��� ����
			int s = Integer.parseInt(st.nextToken()) - 1;
			// ���� ����
			int e = Integer.parseInt(st.nextToken()) - 1;
			// ���
			int w = Integer.parseInt(st.nextToken());
			if(arr[s][e] > w)
				arr[s][e] = w;
		}
		
		// �÷��̵� ���� �˰���
		// k�� ������
		for(int k=0; k<N; k++) {
			// i�� �����
			for(int i=0; i<N; i++) {
				// j�� ������
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
