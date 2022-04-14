package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rabbit {
	// ���� ����?
	// �䳢 �ù����̼�?
	
	// �׳� �ִ� ��������� �ִ� ������ ���̸� ���� ���� �ʴ°�?
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// ù ����
			int now = Integer.parseInt(st.nextToken());
			
			int maxUp = 0;
			int maxDown = 0;
			
			for(int i=0; i<9; i++) {
				int next = Integer.parseInt(st.nextToken());
				
				if(next < now) {
					if(maxDown < now - next) {
						maxDown = now - next;
					}
				}
				else if(next > now) {
					if(maxUp < next - now) {
						maxUp = next - now;
					}
				}
				now = next;
			}
			
			// ������ �����ϴ� �䳢�� ī��Ʈ
			int count = 0;
			
			// �䳢 �Է�
			for(int i=0; i<5; i++) {
				 st = new StringTokenizer(br.readLine());
				 int A = Integer.parseInt(st.nextToken());
				 int B = Integer.parseInt(st.nextToken());
				 
				 if(A>=maxUp && B>=maxDown) {
					 count++;
				 }
			}
			System.out.println("#" + tc + " " + count);
		}
		br.close();
	}
}
