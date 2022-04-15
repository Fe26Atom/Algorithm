package goohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1475 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char N[] = br.readLine().toCharArray();
		int count[] = new int[10];
		
		for(char c : N) {
			count[c-'0']++;
		}
		
		count[6] += count[9] + 1;
		count[6] /=2;
		count[9] = 0;
		
		int max = 0;
		
		for(int i : count) {
			max = Math.max(max, i);
		}
		System.out.println(max);
		br.close();
	}
}
