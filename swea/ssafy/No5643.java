package swea.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5643 {
	
	// �� �л��� �θ���� üũ
	// �� �л��� �Ƶ���� üũ
	// �θ� �� + �Ƶ� �� + �ڽ�  == N �� ���
	// �ڱⰡ �� ������ �ȴ�.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int count = 0;
			
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			Student[] students = new Student[N];
			for(int i=0; i<N; i++) {
				students[i] = new Student();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				
				students[a].parents.add(b);
				students[b].sons.add(a);
			}
			
			for(int i=0; i<N; i++) {
				boolean visit[] = new boolean[N];
				
				Queue<Integer> queue = new LinkedList<>();
				
				// �θ� üũ
				int parentNum = 0;
				
				// �θ� queue�� �ֱ�
				for(int p : students[i].parents) {
					queue.add(p);
					visit[p] = true;
					parentNum++;
				}
				
				// �θ��� �θ� ã��(���� ã��)
				while(!queue.isEmpty()) {
					int p = queue.poll();
					for(int pp : students[p].parents) {
						if(visit[pp]) continue;
						queue.add(pp);
						visit[pp] = true;
						parentNum++;
					}
				}
				
				
				// �ڽ� üũ
				int sonNum = 0;
				
				// �ڽ��� queue�� �ֱ�
				for(int s : students[i].sons) {
					queue.add(s);
					visit[s] = true;
					sonNum++;
				}
				
				// �ڽ��� �ڽ��� ã��(�ڼ� ã��)
				while(!queue.isEmpty()) {
					int s = queue.poll();
					for(int ss : students[s].sons) {
						if(visit[ss]) continue;
						queue.add(ss);
						visit[ss] = true;
						sonNum++;
					}
				}
				
				// ���� + �ڼ� == N - �ڱ� �ڽ�
				if(parentNum + sonNum == N-1)
					count++;
			}
			
			System.out.println("#" + tc + " " + count);
		}
		br.close();
	}
}

class Student{
	// �θ�
	ArrayList<Integer> parents;
	
	// �ڽ�
	ArrayList<Integer> sons;
	
	public Student() {
		parents = new ArrayList<>();
		sons = new ArrayList<>();
	}
}