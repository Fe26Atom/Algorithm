package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합_박철민 {
	
	//https://www.slideshare.net/Baekjoon/baekjoon-online-judge-1019
	
	
	// 상자 만들기
	
	// start는 끝이 0으로 end는 끝이 9로
	// 그 과정에서 따로 값들을 계산
	
	// start가 0이고 end가 9이면
	// 0~9가 (end - start + 1) * digit 개가 나온다.
	
	static long start, end, digit;
	
	static long sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			digit = 1;

			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			
			sum = 0;
			
			while(start <= end) {
				while(start % 10 != 0 && start <= end) {
					counting(start, digit);
					start++;
				}
				
				while(end %10 != 9 && start <= end) {
					counting(end, digit);
					end--;
				}
				
				if(start > end) break;
				
				start /= 10;
				end /= 10;
				
				for(int i = 1; i < 10; i++) {
					sum += i * (end - start + 1) * digit;
				}
				
				digit *= 10;
			}	
			
			sb.append("#"+ tc + " " + sum + "\n");
		}
		System.out.println(sb);
		br.close();
		
	}

	private static void counting(long num, long digit) {
		while(num > 0) {
			sum += num % 10 * digit;
			num /= 10;
		}
	}
}
