package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1194 {
	
	// 미로 벗어나기
	// 빈칸 이동가능
	// 벽 이동 불가능
	// 열쇠를 가지고 있어야 문을 열 수 있다.
	// 현재 서 있는 위치는 '0'
	// 출구는 '1'
	
	// bfs 문제
	// 완전 탐색 문제

	// queue가 빌때까지 전진
	// queue가 빌 경우 만약 도착 못하면 -1
	
	// queue에 들어갈 것은 현재 위치, 이동 숫자, 가지고 있는 열쇠 정보
	
	// visit 관련으로는 키에 여부를 가지고 따져야 한다.
	// 키에 따라 visit가 달라야 한다.
	static int dirx[] = {-1, 0, 1, 0};
	static int diry[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[N][M];
		boolean visit[][][] = new boolean[N][M][1<<7 - 1];
		
		int sx = 0;
		int sy = 0;
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = line.charAt(j);
				if(arr[i][j] == '0') {
					sx = i;
					sy = j;
				}
			}
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(sx, sy, 0, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(int di=0; di<4; di++) {
				int nx = cur.x + dirx[di];
				int ny = cur.y + diry[di];
				int nnum = cur.num + 1;
				int ckey = cur.keys;
				
				// 범위 밖
				if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
				// 이미 다녀왔는지
				if(visit[nx][ny][ckey]) {
					continue;
				}
				
				
				// 벽일 때
				if(arr[nx][ny] == '#') continue;
				
				// 출구 일 때
 				if(arr[nx][ny] == '1') {
 					System.out.println(nnum);
 					return;
 				}

 				// 빈칸 일 때
 				else if(arr[nx][ny] == '.' || arr[nx][ny] == '0'){
 					queue.add(new Node(nx, ny, nnum, ckey));
 					visit[nx][ny][ckey] = true;
 				}
 				// 키를 얻었을 때
 				
 				else if('a' <= arr[nx][ny] && arr[nx][ny] <= 'f'){
 					int keyNo = arr[nx][ny] - 'a';
 					int nkey = ckey | 1<< keyNo;
 					queue.add(new Node(nx, ny, nnum, nkey));
 					visit[nx][ny][nkey] = true;
 				}
 				
 				else if('A' <= arr[nx][ny] && arr[nx][ny] <= 'F'){
 					int doorNo = arr[nx][ny] - 'A';
 					// 맞는 키가 있으면
 					if(((1 << doorNo) & ckey) > 0) {
 	 					queue.add(new Node(nx, ny, nnum, ckey));
 	 					visit[nx][ny][ckey] = true;
 					}
 				}
 	 				
			}
		}
		System.out.println(-1);
	}
}
class Node {
	int x, y;
	int num; 
	int keys;
	
	public Node(int x, int y, int num, int keys) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;
		this.keys = keys;
	}
}