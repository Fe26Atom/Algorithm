package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3985 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int L = Integer.parseInt(br.readLine());
		boolean used[] = new boolean[L];
		
		int N = Integer.parseInt(br.readLine());
		int people[] = new int[N];
		
		int preIdx = 0;
		int maxCount = 0;
		int maxIdx = 0;
		
		for(int i=0; i<N; i++) {
			String[] inputs = br.readLine().split(" ");
			int s = Integer.parseInt(inputs[0])-1;
			int l = Integer.parseInt(inputs[1])-1;
			
			if(l-s>maxCount) {
				maxCount = l-s;
				preIdx = i;
			}
			
			for(int j=s; j<=l; j++) {
				if(used[j]) continue;
				used[j] = true;
				people[i]++;
			}
			if(people[i] > people[maxIdx]) {
				maxIdx = i;
			}
		}
		sb.append(preIdx + 1).append("\n").append(maxIdx + 1).append("\n");
		System.out.println(sb);
		br.close();
	}
}
