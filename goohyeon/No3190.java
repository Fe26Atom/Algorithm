package goohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No3190 {
	
	// dequeue 현재 뱀의 위치를 기록
	
	// 뱀의 머리에서 전진하면 deque의 앞에 넣기
	// 뱀의 꼬리를 빈칸으로 만들기
	
	// 2차원 배열
	// 0 빈칸
	// 1 뱀
	// 2 사과
	
	static int N;
	static int mat[][];
	
	static int dirx[] = new int[] {0, 1, 0, -1};
	static int diry[] = new int[] {1, 0, -1, 0};
	
	static int didx = 0;
	
	static Deque<int[]> deque;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		mat = new int[N][N];
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			mat[x][y] = 2; // 2는 사과
		}
		
		int L = Integer.parseInt(br.readLine());
		
		deque = new LinkedList<>();
		
		mat[0][0] = 1;
		deque.add(new int[] {0,0});
		didx = 0;
		
		int count = 0;
		boolean check = false;
		
//		for(int x=0; x<N; x++) {
//			for(int y=0; y<N; y++) {
//				System.out.print(mat[x][y] + " ");
//			}System.out.println();
//		}
//		System.out.println();
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char nd = st.nextToken().charAt(0);
			
			while(time != count) {
				count++;
				if(!go()) {
					check = true;
					break;
				}
//				for(int x=0; x<N; x++) {
//					for(int y=0; y<N; y++) {
//						System.out.print(mat[x][y] + " ");
//					}System.out.println();
//				}
//				System.out.println();
			}
			
			if(check) break;
			didx = nd == 'L' ? didx - 1 : didx + 1;
			didx = didx % 4;
		}
		while(!check) {
			count++;
			if(!go()) {
				check = true;
				break;
			}
		}
		
		System.out.println(count);
		br.close();
		
	}

	private static boolean go() {

		// 가장 최근
		int cx = deque.peekLast()[0];
		int cy = deque.peekLast()[1];
		
		int nx = cx + dirx[didx];
		int ny = cy + diry[didx];
		
		if(nx== -1 || ny== -1 || nx == N || ny == N)
			return false;
		
		if(mat[nx][ny] == 1) 
			return false;
		
		// 빈칸이면 꼬리 삭제
		if(mat[nx][ny]==0) {
			int tx = deque.peekFirst()[0];
			int ty = deque.peekFirst()[1];
			deque.pollFirst();
			mat[tx][ty] = 0;
		}
		
		// 사과(2)인 경우 꼬리 삭제 생략
		deque.addLast(new int[] {nx, ny});
		mat[nx][ny] = 1;
		
		return true;
	}
}
