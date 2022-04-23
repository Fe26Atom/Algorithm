package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No16916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();

		int alen = a.length();
		int blen = b.length();

		int pi[] = new int[blen];
		
		for(int i=1, j=0; i<blen; i++) {
			while(j>0 && b.charAt(i) != b.charAt(j))
				j = pi[j-1];
			if(b.charAt(i) == b.charAt(j))
				pi[i] = ++j;
		}
		
		int j=0;
		int result = 0;
		for(int i=0; i<alen; i++) {
			while(j > 0 && a.charAt(i) != b.charAt(j)) { 
				j = pi[j-1];
			}
			
			if(a.charAt(i) == b.charAt(j)) {
				if(j == blen - 1) {
					result = 1;
					break;
				}
				else
					++j;
			}
			if(result ==1) break;
		}
		System.out.println(result);
		br.close();
	}
}
