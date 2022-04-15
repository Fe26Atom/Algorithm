package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3052 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean check[] = new boolean[42];
		int count = 0;
		for(int i=0; i<10; i++) {
			int num =Integer.parseInt(br.readLine());
			if(check[num%42]) continue;
			check[num%42] = true;
			count++;
		}
		System.out.println(count);
		br.close();
	}
}
