package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1194 {
	
	// �̷� �����
	// ��ĭ �̵�����
	// �� �̵� �Ұ���
	// ���踦 ������ �־�� ���� �� �� �ִ�.
	// ���� �� �ִ� ��ġ�� '0'
	// �ⱸ�� '1'
	
	// bfs ����
	// ���� Ž�� ����

	// queue�� �������� ����
	// queue�� �� ��� ���� ���� ���ϸ� -1
	
	// queue�� �� ���� ���� ��ġ, �̵� ����, ������ �ִ� ���� ����
	
	// visit �������δ� Ű�� ���θ� ������ ������ �Ѵ�.
	// Ű�� ���� visit�� �޶�� �Ѵ�.
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
				
				// ���� ��
				if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
				// �̹� �ٳ�Դ���
				if(visit[nx][ny][ckey]) {
					continue;
				}
				
				
				// ���� ��
				if(arr[nx][ny] == '#') continue;
				
				// �ⱸ �� ��
 				if(arr[nx][ny] == '1') {
 					System.out.println(nnum);
 					return;
 				}

 				// ��ĭ �� ��
 				else if(arr[nx][ny] == '.' || arr[nx][ny] == '0'){
 					queue.add(new Node(nx, ny, nnum, ckey));
 					visit[nx][ny][ckey] = true;
 				}
 				// Ű�� ����� ��
 				
 				else if('a' <= arr[nx][ny] && arr[nx][ny] <= 'f'){
 					int keyNo = arr[nx][ny] - 'a';
 					int nkey = ckey | 1<< keyNo;
 					queue.add(new Node(nx, ny, nnum, nkey));
 					visit[nx][ny][nkey] = true;
 				}
 				
 				else if('A' <= arr[nx][ny] && arr[nx][ny] <= 'F'){
 					int doorNo = arr[nx][ny] - 'A';
 					// �´� Ű�� ������
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