package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No17413 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		boolean flag = false;
		
		for(char c : line.toCharArray()) {
			
			if(c=='<' || c== '>') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(c);
				flag = !flag;
				continue;
			}
			if(flag) sb.append(c);
			
			else {
				if(c== ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(' ');
				}
				else stack.add(c);
			}

		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
		br.close();
	}
}
