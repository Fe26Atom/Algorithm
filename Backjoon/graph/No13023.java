package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No13023 {
	// A -> B -> C -> D -> E
	// 이러한 친구가 있는지
	// 즉 깊이가 4이상인 친구가 있는지
	
	// A의 친구 목록을 탐색한다
	// 친구의 친구로 간다.
	// 친구의 친구의 친구로 간다.
	
	// 이걸 반복해서 방문하지 않은 친구들을 나열해 5명 이상인지 확인한다.
	
	// 양방향 그래프의 깊이 우선 탐색
	
	// A -> B -> C -> D -> E 깊이는 4
	// deapth == 4일 경우 까지 찾아본다.
	
	// visit 여부 확인울 해줘야 한다.
	// 안 해도 될 것 같다.
	
	// 대각선을 기준으로 왼쪽으로 가면 된다.
	
	
	// N명, M개의 관계
	static int N, M;
	
	static ArrayList<Integer> friends[];
	
	// 방문 여부를 확인한다.
	static boolean visit[];
	
	// ABCDE가 되는지
	static boolean AtoE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friends = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			friends[i] = new ArrayList<Integer>();
		}
		
		visit = new boolean[N];
		
		AtoE = false;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			friends[a].add(b);
			friends[b].add(a);
			
		}
		
		for(int i=0; i<N; i++) {
			visit[i] = true;
			dfs(1, i);
			visit[i] = false;
			if(AtoE) break;
		}
		
		if(AtoE) 
			System.out.println(1);
		else
			System.out.println(0);
		br.close();
	}

	private static void dfs(int depth, int posi) {
		if(depth==5) {
			AtoE = true;
			return;
		}
		
		for(int next: friends[posi]) {
			if(visit[next]) continue;
			
			visit[next] = true;
			dfs(depth + 1, next);
			visit[next] = false;
		}
	}
}
