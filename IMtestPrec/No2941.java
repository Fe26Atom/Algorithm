package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2941 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		input += "  ";
		int count = 0;
		
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			if(c ==' ') break;
			
			count++;
			
			if(c == 'c') {
				if(input.charAt(i + 1) == '=' ||input.charAt(i + 1) == '-')
					i++;
			}
			else if(c=='d') {
				if(input.charAt(i + 1) == 'z' && input.charAt(i + 2) == '=')
					i+=2;
				else if(input.charAt(i + 1) == '-')
					i++;
			}
			else if(c=='l' && input.charAt(i + 1) =='j') 
				i++;
			else if(c=='n' && input.charAt(i + 1) =='j') 
				i++;
			else if(c=='s' && input.charAt(i + 1) =='=') 
				i++;
			else if(c=='z' && input.charAt(i + 1) =='=') 
				i++;
		}
		System.out.println(count);
		br.close();
	}
}
