package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9093 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String in[][] = new String[N][];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			in[i] = br.readLine().split(" ");
		}
		
		for(String line[] : in) {
			for(String s : line) {
				sb.append(rev(s));
				sb.append(" ");
			}sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	private static String rev(String s) {
		String rev = "";
		for(int i=s.length()-1; i>=0; i--) {
			rev += s.charAt(i);
		}
		return rev;
	}
}
