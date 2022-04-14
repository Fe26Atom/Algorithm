package pdf.ssafy;


public class ws02_아파트색칠하기 {
	//dp 문제
	// n-1 n-2가 같을 경우 n은 그 색이 되면 x
	
	// f(n) = f(n-1) * 2 - (3개가 같은 경우)
	
	// 이걸 아얘 분리할 것
	
	// 끝이 파랑인것, 끝이 노랑인 것
	
	// 끝이 파랑인 것 + 노랑 1개 or 노랑 2개
	// 끝이 노랑인 것 + 노랑 1개 + 파랑 1개
	
	
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
