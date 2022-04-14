package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rabbit {
	// 구현 문제?
	// 토끼 시물레이션?
	
	// 그냥 최대 오르막길과 최대 내리막 차이를 보면 되지 않는가?
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 첫 시작
			int now = Integer.parseInt(st.nextToken());
			
			int maxUp = 0;
			int maxDown = 0;
			
			for(int i=0; i<9; i++) {
				int next = Integer.parseInt(st.nextToken());
				
				if(next < now) {
					if(maxDown < now - next) {
						maxDown = now - next;
					}
				}
				else if(next > now) {
					if(maxUp < next - now) {
						maxUp = next - now;
					}
				}
				now = next;
			}
			
			// 조건을 만족하는 토끼를 카운트
			int count = 0;
			
			// 토끼 입력
			for(int i=0; i<5; i++) {
				 st = new StringTokenizer(br.readLine());
				 int A = Integer.parseInt(st.nextToken());
				 int B = Integer.parseInt(st.nextToken());
				 
				 if(A>=maxUp && B>=maxDown) {
					 count++;
				 }
			}
			System.out.println("#" + tc + " " + count);
		}
		br.close();
	}
}
