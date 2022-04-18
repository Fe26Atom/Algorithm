package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11401 {
	
	// 페르마의 소정리
	// 분할 정복
	
	// 재귀

	static final long P = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long facN = fac(N);
		long facK = fac(K);
		long facNK = fac(N-K);
		
		System.out.println(facN * pow(facK * facNK % P, P-2) % P);
		br.close();
	}

	private static long pow(long num, long expo) {

		if(expo==1) {
			return num % P;
		}
		
		long temp = pow(num, expo/2);
		
		if(expo % 2==1) {
			return (temp * temp % P ) * num % P;
		}
		return temp * temp % P;
	}

	private static long fac(long N) {
		long fac = 1L;
		
		while(N > 1) {
			fac = (fac * N) % P;
			N--;
		}
		return fac;
	}
}
