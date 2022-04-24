package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1019 {
	
	static long cnt[] = new long[10];
	
	static int start, end, digit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		start = 1;
		end = Integer.parseInt(br.readLine());
		digit = 1;
		
		cnt = new long[10];
		
		while(start <= end) {
			while(start % 10 != 0 && start <= end) {
				counting(start, digit);
				start++;
			}
			
			while(end % 10 != 9 && start <= end) {
				counting(end, digit);
				end--;
			}
			
			if(start > end) break;
			
			start /= 10;
			end /= 10;
			
			for(int i=0; i<10; i++) {
				cnt[i] += (end - start + 1) * digit;
			}
			
			digit *= 10;
		}
		
		for(long i : cnt) {
			System.out.print(i + " ");
		}
		br.close();
	}

	private static void counting(int num, int digit) {
		while(num > 0) {
			cnt[num % 10] += digit;
			num /= 10;
		}
		
	}
}
