package kkako;

public class Menu {

}

class Solution {
	char arr[];
	boolean used[] = new boolean[26];
	int max = 0;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = new String[course.length];
       
        for(String order : orders) {
        	for(char c : order.toCharArray()) {
        		used[c - 'A']=true;
        	}
        }
        
        for(int i=0; i<course.length; i++) {
        	arr = new char[course[i]];
        	max = 0;
        	dfs(0, 0 ,course[i], orders);
        }
        
        return answer;
    }

	private void dfs(int start, int depth, int goal, String[] orders) {
		if(depth==goal) {
			int count = 0;
			
			for(String order : orders) {
				boolean check = true;
				for(char c : arr) {
					if(!order.contains(""+c)) {
						check = false;
						break;
					}
				}
				if(check) count++;
			}
			
			if(count > max) {
				
			}
		}
		
		for(int i=start; i<26; i++) {
			if(!used[i])continue;
			arr[depth] = (char) ('A' + i);
			dfs(i+1, depth+1, goal, orders);
		}
	}
}