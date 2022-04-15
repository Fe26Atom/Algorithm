package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2991 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A  =Integer.parseInt(st.nextToken());
		int B  =Integer.parseInt(st.nextToken());
		int C  =Integer.parseInt(st.nextToken());
		int D  =Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int P  =Integer.parseInt(st.nextToken());
		int M  =Integer.parseInt(st.nextToken());
		int N  =Integer.parseInt(st.nextToken());

		int p = ((P-1) % (A+B) < A ? 1 : 0 ) + ((P-1) % (C+D) < C  ? 1 : 0 );
		int m = ((M-1) % (A+B) < A ? 1 : 0 ) + ((M-1) % (C+D) < C  ? 1 : 0 );
		int n = ((N-1) % (A+B) < A ? 1 : 0 ) + ((N-1) % (C+D) < C  ? 1 : 0 );
		
		sb.append(p).append("\n").append(m).append("\n").append(n);
		System.out.println(sb);
		br.close();
	}
}
