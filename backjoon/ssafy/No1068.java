package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1068 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		Node[] tree = new Node[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		

		
		
	}
	class Node {
		Node parent;
		ArrayList<Node> child = new ArrayList<>();
	}
}
