package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class city2 {
	// dfs ����
	
	// ����
	
	// vCp �߿��� ���� �ּڰ� ������ ��� ã��
	
	
	static int V, P, L;
	
	static int min = Integer.MAX_VALUE;

	static int minPol[];
	
	static int city[];
	static int police[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			city = new int[V];
			police = new int[P];
			minPol = new int[P];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<V; i++) {
				city[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			
			System.out.println("#" + tc + " "+ min);
			for(int i : minPol) {
				System.out.print(city[i] + " ");
			}System.out.println();
		}
		br.close();
	}

	
	// ����
	private static void dfs(int start, int depth) {
		if(depth == P) {
			check();
			return;
		}
		
		for(int i=start; i<V; i++) {
			police[depth] = i;
			dfs(i+1, depth+1);
		}
	}

	// �ּ� �Ÿ����� Ȯ���ϱ�
	private static void check() {
		int minSum = 0;
		for(int i=0; i<V; i++) {
			int mindi = V;
			
			for(int p : police) {
				int di = Math.min(Math.abs(city[i] - city[p]), L - Math.abs(city[i] - city[p]) );
				mindi = Math.min(mindi, di);
			}
			minSum += mindi;
		}
		
		if(min > minSum) {
			min = minSum;	
			minPol = police.clone();
		}
		
	}
}
