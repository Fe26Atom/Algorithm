package backjoon.swstudy;

import java.util.Scanner;

public class ������_��ö��2 {
	
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
			// ���� �������� ������ �ڸ��� 0�� �� �� ���� ++ 
			while(start % 10 != 0 && start <= end) {
				counting(start, digit);
				start++;
			}
			
			// ������ �������� ������ �ڸ��� 9�� �� �� ���� -- 
			while(end % 10 != 9 && start <= end) {
				counting(end, digit);
				end--;
			}
			
			if(start > end) break;
			
			// ������ �ڸ����� �����Ѵ�. 
			start /= 10;
			end /= 10;
			
			// start ~ end ������ 0 ~ 9 ������ ��� ����.
			// ���� �ڸ��� ��ŭ ��������Ѵ�. 
			for(int i = 0 ; i < 10 ; ++i) {
				cnt[i] += (end - start + 1) * digit;
				sum += i * (end - start + 1) * digit;
			}
			
			// �ڸ����� ���δ�. 
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
