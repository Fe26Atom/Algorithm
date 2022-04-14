package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// i��°�� i����ŭ ������ �� �ִ�.
// i��°���� ������ �� �ִ� �� �Ÿ� i*(i+1)/2 (�׳� i ��� ���ѰͰ� ���� �ϴ�)
// �� �Ÿ� - (���� �ָ��ִ� ��)�� ¦������ ���� ������ ������ ������ �ִ´�.
// �� �Ÿ��� ���� �ָ� �ִ� ���� �Ÿ����� Ŀ���Ѵ�.
// ��� ���� �Ÿ��� ��� ¦��, ��� Ȧ�������Ѵ� (�ȱ׷��� ���� ������ ���� �������� ��� �����)


public class No8458_2 {
	static int maxDist;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			maxDist = 0;
			
			boolean isAllEven = false;
			boolean isAllOdd = false;
			for (int i=0; i<N; i++) {
				String[] s0 = in.readLine().split(" ");
				int dist = getDist(Integer.parseInt(s0[0]), Integer.parseInt(s0[1]));
				if (isEven(dist)) isAllEven = true; // ��� ¦����� ����
				else isAllOdd = true; // ��� Ȧ����� ����
				maxDist = Math.max(maxDist, dist); // ���� �ָ� �ִ� ��
			}
			if (isAllEven && isAllOdd) { // �Ѵ� ���ΰ� ���� �ȵǹǷ� -1
				sb.append("#").append(tc).append(" ").append(-1).append("\n");
				continue;
			}
			System.out.println("max:" + maxDist);
			int idx = 0;
			int count = 0;
			while(true) {
				count += idx; // idx��ŭ ������ �� �ִ� �� �Ÿ��� ������
				if (count >= maxDist && isEven(count - maxDist)){ 
					sb.append("#").append(tc).append(" ").append(idx).append("\n");
					break;
				}
				idx++;
			}
		}
		System.out.println(sb.toString());
	}
	
	
	static int getDist(int x, int y) {
		return Math.abs(x) + Math.abs(y);
	}
	
	static boolean isEven(int x) {
		if (x%2 != 0) return false;
		return true;
	}
	
}
