package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String ans;
		
		ans = (N % 2 == 0) ? "CY" : "SK";
		System.out.println(ans);
		br.close();
	}
}
