package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17471 {
	
	// 모든 경우의 수 만들어주기
	// 경우의 수가 가능한지 체크
	// 가능할 경우 최솟값 비교하기
	
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
		
		// 초기값이 그대로다 == 두 선거구로 나눌 수 없는 경우
		if(min==10000) min = -1;
		
		System.out.println(min);
	}

	// 모든 경우의 수 만들어주기
	private static void dfs(int depth) {
		
		if(depth==N) {
//			for(int i : arr) {
//				System.out.print(i + " ");
//			}System.out.println();
			
			// 확인해주기
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
			
		// i구가 1번에 들어갔을 때
		arr[depth] = 1;
		dfs(depth + 1);
			
		// i구가 2번에 들어갔을 때
		arr[depth] = 2;
		dfs(depth + 1);
	}
	
	// 확인해주기
	private static boolean check() {

		int os = -1;
		int ts = -1;
		
		for(int i=0; i<N; i++) {
			if(arr[i] == 1)
				os = i;
			else
				ts = i;
		}
		
		// 하나도 선택되지 않은 경우 제외하기
		if(os==-1 || ts == -1)
			return false;
		
		// 연결 여부 확인하기
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
		
		// 모든 애들이 색칠됬다면 true
		if(count==N)
			return true;
		
		return false;
	}


}
