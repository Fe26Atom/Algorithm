package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14891 {
	
	// 톱니 바퀴를 회전
	// 만약 닿은 접점이 서로 다를 경우
	// 방향이 달라짐
	// 만약 닿은 접점이 같으면 회전하지 않는다.
	
	// 구현 문제
	
	static int di[];
	static int gears[][];
	static boolean visit[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 현재 12시 방향에 누가 와 있는지 기록
		di = new int[] {0,0,0,0};
		
		gears = new int[4][8];
		
		for(int i=0; i<4; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) {
				gears[i][j] = line.charAt(j)-'0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
//		for(int i=0; i<4; i++) {
//			System.out.print(gears[i][di[i]] + " ");
//		}System.out.println();
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			visit = new boolean[4];
			int no = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			visit[no] = true;
			move(no, dir) ;
		}
		
		int ans = 0;
		
		for(int i=0; i<4; i++) {
			ans += gears[i][di[i]] << i;
		}
		
//		for(int i=0; i<4; i++) {
//			System.out.print(gears[i][di[i]] + " ");
//		}System.out.println();
//		
		System.out.println(ans);
		br.close();
	}

	private static void move(int no, int dir) {
		// 왼쪽 체크
		if(no !=0) {
			if(!visit[no-1]) {
				int curGL = gears[no][(di[no]+ 6)%8];
				int leftGR = gears[no-1][(di[no-1]+2)%8];
				
				if(leftGR != curGL) {
					visit[no-1] = true;
					move(no - 1, dir * -1);
				}
			}
		}
		
		// 오른쪽 체크
		if(no !=3) {
			if(!visit[no+1]) {
				int curGR = gears[no][(di[no]+2)%8];
				int rightGL = gears[no + 1][(di[no + 1]+ 6)%8];
				
				if(rightGL != curGR) {
					visit[no+1] = true;
					move(no + 1, dir * -1);
				}
			}
		}
		// 회전하기
		di[no] = (di[no] - dir + 8) % 8;
		
//		for(int i=0; i<4; i++) {
//			System.out.print(gears[i][di[i]] + " ");
//		}System.out.println();
	}
}
