package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No21608 {
	static boolean used[];
	static int arr[][];
	static int info [][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		used = new boolean[N * N];
		
		arr = new int[N][N];
		
		info = new int[N * N][2];
		
		
		
	}
}
