package pdf.ssafy;


public class ws02_����Ʈ��ĥ�ϱ� {
	//dp ����
	// n-1 n-2�� ���� ��� n�� �� ���� �Ǹ� x
	
	// f(n) = f(n-1) * 2 - (3���� ���� ���)
	
	// �̰� �ƾ� �и��� ��
	
	// ���� �Ķ��ΰ�, ���� ����� ��
	
	// ���� �Ķ��� �� + ��� 1�� or ��� 2��
	// ���� ����� �� + ��� 1�� + �Ķ� 1��
	
	
	// B[n] = Y[n-1] + Y[n-2]
	// Y[n] = B[n-1] + Y[n-1]
	
	public static void main(String[] args) {
		
		int B[] = new int [9];
		int Y[] = new int [9];
		
		B[0] = 0;
		Y[0] = 0;
		
		B[1] = 1;
		Y[1] = 1;
		
		for(int i=2; i<9; i++) {
			B[i] = Y[i-1];
			Y[i] = B[i-1] + Y[i-1];
		}
		
		System.out.println(B[8] + Y[8]);
		
	}
}
