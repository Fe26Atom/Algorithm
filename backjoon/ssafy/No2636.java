package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2636 {
	// bfs 
	
	// �丶��� ���� Ǯ ��
	
	// ���� ���� ġ�� 
	// ���� ������ ġ�� 
	
	// ó�� ���۽� ���� ���� ���θ� üũ�Ѵ�.
	// queue�� �̵��ؼ� üũ?
	
	// ���� ���� ġ� queue�� �ֱ�
	// queue���� ������ ���ֱ�-> ���ָ鼭 �ֺ��� ġ� 3���� �ٲٱ�
	// ���� fġ� tġ� �Ǹ� ���ο� queue�� �־��ֱ�
	// queue�� �������� 
	
	// queue�� �� �������� �� queue�� �ٲ��ֱ�
	// size�� ��� ����
	// ������ ����� ����
	// ���̵� ����.
	
	static int dirx[] = {-1,0,1,0};
	static int diry[] = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h= Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int mat[][] = new int[h][w];
		int air[][] = new int[h][w];
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		bfs�� ���� queue
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// ������ ���� 
		for(int i=0; i<h; i++) {
			queue.add(new int[] {0,i});
		}
		
		for(int i=0; i<w; i++) {
			queue.add(new int[] {i,0});
		}
		
		// ���� ���� ���� üũ
		
		// ���� ���� ġ�� üũ�� ���� queue
		Queue<int[]> nq = new LinkedList<int[]>();
		int size = queue.size();
		int depth = 0;
		
		while(!queue.isEmpty()) {			
			int[] cur = queue.poll();
			
			for(int di=0; di<4; di++) {
				int nx = cur[0]+dirx[di];
				int ny = cur[1]+diry[di];
				
				if(nx<0 || ny<0 || nx >= h || ny >= w) continue;
				
				if(mat[nx][ny]!= -1 ) {
					// ġ��� ���� queue�� �ֱ�
					if(mat[nx][ny]== 1 )
						nq.add(new int[] {nx, ny});
					// ����� ���� queue�� �ֱ�
					else
						queue.add(new int[] {nx, ny});
					mat[nx][ny]= -1;
				}
			}
			
			if(queue.size()==0) {
				if(nq.size()==0) break;
				
				depth++;
				size = nq.size();
				queue = nq;
				nq = new LinkedList<>();
			}
		}
		System.out.println(depth);
		System.out.println(size);
		
		br.close();
	}
}
