package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2577 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		int max = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int visit[] = new int[3001];
		int count = 0;
		
		// 0 부터 k개까지 체크
		// start가 0
		for(int i=0; i<k; i++) {
			visit[arr[i]]++;
			if(visit[arr[i]]==1)
				count++;
		}
		
		// 윈도우 슬라이드
		// start 0부터 시작해서 N - 1 시작
		for(int i=0; i<N; i++) {
			visit[arr[i]]--;
			if(visit[arr[i]]== 0)
				count--;
			visit[arr[(i + k) % N]]++;
			if(visit[arr[(i + k) % N]] == 1)
				count++;
			if(visit[c]==0) {
				count++;
				max = max > count ? max : count;
				count--;
			}
			max = max > count ? max : count;
			
		}
		
		System.out.println(max);
		br.close();
	}
}
