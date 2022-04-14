package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17471 {
	
	// ��� ����� �� ������ֱ�
	// ����� ���� �������� üũ
	// ������ ��� �ּڰ� ���ϱ�
	
	static int N;
	static int min = 10000;
	
	static int pop[];
	static int arr[];
	static boolean visit[];
	static boolean mat[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		pop = new int[N];
		arr = new int[N];
		mat = new boolean[N][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				mat[i][Integer.parseInt(st.nextToken()) - 1] = true;
			}
		}
		
		dfs(0);
		
		// �ʱⰪ�� �״�δ� == �� ���ű��� ���� �� ���� ���
		if(min==10000) min = -1;
		
		System.out.println(min);
	}

	// ��� ����� �� ������ֱ�
	private static void dfs(int depth) {
		
		if(depth==N) {
//			for(int i : arr) {
//				System.out.print(i + " ");
//			}System.out.println();
			
			// Ȯ�����ֱ�
			if(check()) {
				int oneNum = 0;
				int twoNum = 0;
				
				for(int i=0;i<N; i++) {
					if(arr[i]==1) {
						oneNum += pop[i];
					}
					else {
						twoNum += pop[i];
					}
				}
				min = Math.min(min, Math.abs(oneNum - twoNum));
			}
			return;
		}
			
		// i���� 1���� ���� ��
		arr[depth] = 1;
		dfs(depth + 1);
			
		// i���� 2���� ���� ��
		arr[depth] = 2;
		dfs(depth + 1);
	}
	
	// Ȯ�����ֱ�
	private static boolean check() {

		int os = -1;
		int ts = -1;
		
		for(int i=0; i<N; i++) {
			if(arr[i] == 1)
				os = i;
			else
				ts = i;
		}
		
		// �ϳ��� ���õ��� ���� ��� �����ϱ�
		if(os==-1 || ts == -1)
			return false;
		
		// ���� ���� Ȯ���ϱ�
		visit = new boolean[N];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(os);
		queue.add(ts);
		
		visit[os] = true;
		visit[ts] = true;
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			int curDang = arr[cur];
			count++;
			
			for(int i=0; i<N; i++) {
				if(visit[i]) continue;
				
				if(arr[i] == curDang && mat[cur][i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
		
		// ��� �ֵ��� ��ĥ��ٸ� true
		if(count==N)
			return true;
		
		return false;
	}


}
