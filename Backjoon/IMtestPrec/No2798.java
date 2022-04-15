package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2798 {
	static int max= 0, N, M, arr[];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		dfs(0,0,0);
		System.out.println(max);
		br.close();
	}
	private static void dfs(int start, int depth, int sum) {
		if(sum > M) return;
		if(depth == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=start; i<N; i++) {
			dfs(i + 1, depth+1, sum + arr[i]);
		}
	}
}
