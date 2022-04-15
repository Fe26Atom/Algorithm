package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			int count = 0;
			int score = 1;
			for(int j=1; j<=line.length(); j++) {
				if(line.charAt(j - 1)=='O') {
					count+=score++;
				}
				else
					score = 1;
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
