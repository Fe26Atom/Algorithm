package IMtestPrec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1244 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int S = Integer.parseInt(br.readLine());
		
		for(int i=0; i<S; i++) {
			for(int a=1; a<=N; a++) {
				System.out.print(arr[a] + " ");
			}System.out.println();
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(sex==1) {
				for(int j=idx; j<=N; j+=idx) {
					arr[j] = (arr[j] + 1) % 2;
				}
			}
			else if(sex == 2) {
				int c = 0;
				while( 0 < idx - c && idx + c <= N && (arr[idx+c] == arr[idx-c])) {
					arr[idx+c] = arr[idx-c] = (arr[idx+c] + 1) %2;
					c++;
				}
			}

		}
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i] + " ");
			if(i%20==0)System.out.println();
		}
		br.close();
	}
}
