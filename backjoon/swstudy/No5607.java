package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5607 {
	
	
	// 조합론
	
	// (a^p %p) = (a % p)
	
	// (a^p-1) %p = 1
	// (a^p-2) %p = a
	
	// nCr = n! / r! * (n-r)! % p
	// A = n!, B = (r! * (n-r)!)
	
	// nCr = A * B^(-1) %p
	
	// = (A % p * B^(-1) %p )%p
	
	// = (A * B ^(p-2) ) % p
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			
			long ans = nCr(N, R, 1234567891);
			System.out.println("#"+tc + " " + ans);
		}
	}

	private static long nCr(int n, int r, int p) {
		if(r==0)
			return 1L;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i=1; i<=n; i++) {
			fac[i] = fac[i-1] * i % p;
		}
		// = (A * B ^(p-2) ) % p
		return (fac[n] * power(fac[r], p-2, p) % p * power(fac[n-r], p-2, p) %p) %p;
	}

	
	// 제곱해주기
	private static long power(long x, int y, int p) {
		long res = 1L;
		x= x%p;
		
		while(y > 0) {
			if(y % 2 == 1) 
				res = (res * x) %p;
			y = y>>1;
			x = (x * x) %p;
		}
		return res;
	}
}
