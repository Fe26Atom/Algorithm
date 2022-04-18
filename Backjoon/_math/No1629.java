package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1629 {
	
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B =  Long.parseLong(st.nextToken());
		C =  Long.parseLong(st.nextToken());
		
		System.out.println( pow(A, B));
		br.close();
	}
	private static long pow(long a, long b) {
		if(b == 1) {
			return a % C;
		}
		
		long temp = pow(a, b/2);

		if(b % 2 == 1) {
			return (temp * temp % C) * a % C;
		}
		
		return (temp * temp) % C;
	}
}
