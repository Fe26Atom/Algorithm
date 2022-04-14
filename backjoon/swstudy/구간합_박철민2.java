package backjoon.swstudy;

import java.util.Scanner;

public class 구간합_박철민2 {
	
	static int[] cnt;
	static int start, end, digit;
	
	static long sum = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		digit = 1;
		start = sc.nextInt();
		end = sc.nextInt();
		
		cnt = new int[10];
		
		sum = 0;
		
		while(start <= end) {
			// 시작 페이지의 마지막 자리가 0이 될 때 까지 ++ 
			while(start % 10 != 0 && start <= end) {
				counting(start, digit);
				start++;
			}
			
			// 마지막 페이지의 마지막 자리가 9가 될 때 까지 -- 
			while(end % 10 != 9 && start <= end) {
				counting(end, digit);
				end--;
			}
			
			if(start > end) break;
			
			// 마지막 자릿수를 제거한다. 
			start /= 10;
			end /= 10;
			
			// start ~ end 사이의 0 ~ 9 갯수를 모두 센다.
			// 현재 자릿수 만큼 곱해줘야한다. 
			for(int i = 0 ; i < 10 ; ++i) {
				cnt[i] += (end - start + 1) * digit;
				sum += i * (end - start + 1) * digit;
			}
			
			// 자릿수를 높인다. 
			digit *= 10;
		}
		
		for(long i : cnt) {
			System.out.print(i + " ");
		}
		System.out.println(sum);
	}

	private static void counting(int num, int digit) {
		while(num > 0) {
			cnt[num % 10] += digit;
			sum += (num % 10) * digit;
			num /= 10;
		}
	}
}
