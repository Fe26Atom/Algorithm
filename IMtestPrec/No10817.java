package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10817 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[3];
		
		String inputs[] = br.readLine().split(" ");
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		Arrays.sort(arr);
		System.out.println(arr[1]);
		br.close();
	}
}
