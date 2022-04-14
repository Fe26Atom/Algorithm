package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// i번째는 i번만큼 움직일 수 있다.
// i번째까지 움직일 수 있는 총 거리 i*(i+1)/2 (그냥 i 계속 더한것과 같긴 하다)
// 총 거리 - (가장 멀리있는 점)이 짝수여야 먼저 도착한 점들이 원점에 있는다.
// 총 거리가 가장 멀리 있는 점의 거리보다 커야한다.
// 모든 점의 거리는 모두 짝수, 모두 홀수여야한다 (안그러면 먼저 도착한 점이 원점에서 계속 벗어난다)


public class No8458_2 {
	static int maxDist;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			maxDist = 0;
			
			boolean isAllEven = false;
			boolean isAllOdd = false;
			for (int i=0; i<N; i++) {
				String[] s0 = in.readLine().split(" ");
				int dist = getDist(Integer.parseInt(s0[0]), Integer.parseInt(s0[1]));
				if (isEven(dist)) isAllEven = true; // 모두 짝수라고 가정
				else isAllOdd = true; // 모두 홀수라고 가정
				maxDist = Math.max(maxDist, dist); // 가장 멀리 있는 점
			}
			if (isAllEven && isAllOdd) { // 둘다 참인건 말이 안되므로 -1
				sb.append("#").append(tc).append(" ").append(-1).append("\n");
				continue;
			}
			System.out.println("max:" + maxDist);
			int idx = 0;
			int count = 0;
			while(true) {
				count += idx; // idx만큼 움직일 수 있는 총 거리가 증가함
				if (count >= maxDist && isEven(count - maxDist)){ 
					sb.append("#").append(tc).append(" ").append(idx).append("\n");
					break;
				}
				idx++;
			}
		}
		System.out.println(sb.toString());
	}
	
	
	static int getDist(int x, int y) {
		return Math.abs(x) + Math.abs(y);
	}
	
	static boolean isEven(int x) {
		if (x%2 != 0) return false;
		return true;
	}
	
}
