package bfs;
// https://www.acmicpc.net/problem/14502
// ������

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back14502 {
	
	// ��ĭ 3���� �����ϱ�
	
	// ���� �� bfs�� ���� ��ĥ�ϱ�
	
	// bfs�� ��ĥ�� �ֵ� �� ���� ���� ĥ�� ��츦 ���ϱ�
	
	// 0�� ���� - 3(�� ����) - ���� ���� ĥ�� ����
	
	static int N;
	static int M;
	static int[][] mat;
	
	static int min;
	
	static ArrayList<int[]> zeros;
	static ArrayList<int[]> twos;

	static int dirx[] = new int[] {-1, 0, 1, 0};
	static int diry[] = new int[] {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat = new int[N][M];
		zeros = new ArrayList<>();
		twos = new ArrayList<>();
		
		min = Integer.MAX_VALUE;
		
		int negative = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j] == 0) {
					zeros.add(new int[] {i, j});
					negative++;
				}
				if(mat[i][j]==2) {
					twos.add(new int[] {i, j});
				}
			}
		}
		
		// �����ϱ�
		dfs(0, 0);
		
		System.out.println(negative- min - 3);
		br.close();
	}

	private static void dfs(int depth, int start) {
		if(depth == 3) {
			// ũ�� Ȯ��
			check();
			return;
		}
		
		for(int i=start; i<zeros.size(); i++) {
			int x = zeros.get(i)[0];
			int y = zeros.get(i)[1];
			
			mat[x][y] = 1;
			dfs(depth+1, i+1);
			mat[x][y] = 0;
		}
	}

	// ��ĥ�ϱ�
	private static void check() {
		int count = 0;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		boolean visit[][] = new boolean[N][M];
		
		for(int[] i : twos) {
			queue.add(i);
		}
		
		// ��ĥ�ϱ�
		while(!queue.isEmpty()) {
			int curx = queue.peek()[0];
			int cury = queue.peek()[1];
			
			queue.poll();
			
			for(int di=0; di<4; di++) {
				int nx = curx + dirx[di];
				int ny = cury + diry[di];
				
				if(nx<0 || ny<0 || nx>=N || ny>= M) continue;
				if(mat[nx][ny]!=0)continue;
				if(visit[nx][ny]) continue;
				
				visit[nx][ny] = true;
				count++;
				queue.add(new int[] {nx, ny});
			}
		}
		
		min = Math.min(min, count);
	}
}
