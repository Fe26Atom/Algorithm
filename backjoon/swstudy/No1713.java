package backjoon.swstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No1713 {
	
	// 지금 틀에 들어가 있는지 체크
	static boolean used[] = new boolean[101];
	// 후보가 불린 수
	static int count[] = new int[101];
	// 가장 최근 
	static int last[] = new int[101];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//3
		int N = Integer.parseInt(br.readLine());
		// 9
		int C = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		// i =0 < c - 1번째
		for (int i = 0; i < C; i++) {
			// num
			int num = Integer.parseInt(st.nextToken());
			// 틀에 없는 학생이 불림
			if(!used[num]) {
				arr.add(num);
				last[num] = i;
			}
			count[num]++;
			used[num] = true;
			Collections.sort(arr, new myComparator());
			
			// 사이즈를 체크  
			if (arr.size() > N) {
				int rev = arr.get(0);
				// 만약 앞에 있는 게 방금 들어간 거다.
				if(rev == num){
					
					// 이 뒤에있는거 제거
					rev  =arr.get(1);
					arr.remove(1);
				}
				else
					arr.remove(0);
				count[rev] = 0;
				used[rev] = false;
			}

//			for (int a : arr) {
//				System.out.print(a + " ");
//			}
//			System.out.println();
		}
		Collections.sort(arr, (o1, o2) -> o1 - o2);

		for (int i : arr) {
			System.out.print(i + " ");
		}
		br.close();
	}

	static class myComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (count[o1] == count[o2])
				return last[o1] - last[o2];
			return count[o1] - count[o2];
		}
	}
}
