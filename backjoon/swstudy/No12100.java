package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12100 {
	// 1. ���� ��ǥ������ ��
	// 2. for������ �ֵ��� �� �̵����Ѻ�
	// 3. ���� �̵��ϴٰ� ������ �� ������ ��ġ�� �ƴϸ� �浹
	// 4. �� ���̰� 5�� �ɶ����� �ݺ�
	// -> dfs�� ���� Ǯ��
	
	static int max = Integer.MIN_VALUE;
	static int N;
	
	static int dirx[] = { -1, 0, 1, 0 };
	static int diry[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int arr[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(max);
		br.close();
		
		
	}

	private static void dfs(int i) {
		// TODO Auto-generated method stub
		
	}

}
