package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No8458 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			int maxdist = 0;
			
			int N = Integer.parseInt(br.readLine());
			
			boolean check = false;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(check) continue;
				
				int dist = Math.abs(x) + Math.abs(y);
				if(i > 0 && (maxdist - dist) % 2 == 1) {
					check = true;
					continue;
				}
				if(maxdist < dist) {
					maxdist = dist;
				}
			}
			int idx = 0;
			int count = 0;
			
			if(check) {
				idx = -1;
				sb.append("#" + tc + " " + idx+"\n"); 
				continue;
			}
			
			while(true) {
				count += idx;
				
				if(count >= maxdist && (count - maxdist) % 2==0) {
					sb.append("#" + tc + " " + idx+"\n"); 
					break;
				}
				idx++;
			}
		}
		System.out.println(sb);
		br.close();
	}
}
