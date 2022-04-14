package swea.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5643 {
	
	// 각 학생의 부모들을 체크
	// 각 학생의 아들들을 체크
	// 부모 수 + 아들 수 + 자신  == N 일 경우
	// 자기가 몇 등인지 안다.
	
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
				
				// 부모 체크
				int parentNum = 0;
				
				// 부모를 queue에 넣기
				for(int p : students[i].parents) {
					queue.add(p);
					visit[p] = true;
					parentNum++;
				}
				
				// 부모의 부모를 찾기(조상 찾기)
				while(!queue.isEmpty()) {
					int p = queue.poll();
					for(int pp : students[p].parents) {
						if(visit[pp]) continue;
						queue.add(pp);
						visit[pp] = true;
						parentNum++;
					}
				}
				
				
				// 자식 체크
				int sonNum = 0;
				
				// 자식을 queue에 넣기
				for(int s : students[i].sons) {
					queue.add(s);
					visit[s] = true;
					sonNum++;
				}
				
				// 자식의 자식을 찾기(자손 찾기)
				while(!queue.isEmpty()) {
					int s = queue.poll();
					for(int ss : students[s].sons) {
						if(visit[ss]) continue;
						queue.add(ss);
						visit[ss] = true;
						sonNum++;
					}
				}
				
				// 조상 + 자손 == N - 자기 자신
				if(parentNum + sonNum == N-1)
					count++;
			}
			
			System.out.println("#" + tc + " " + count);
		}
		br.close();
	}
}

class Student{
	// 부모
	ArrayList<Integer> parents;
	
	// 자식
	ArrayList<Integer> sons;
	
	public Student() {
		parents = new ArrayList<>();
		sons = new ArrayList<>();
	}
}