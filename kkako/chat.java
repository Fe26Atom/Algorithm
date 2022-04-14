//package kkako;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class chat {
//	public static void main(String[] args) {
//		Solution solution = new Solution();
//		
//		solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
//	}
//}
//
//class Solution {
//    public String[] solution(String[] record) {
//        String[] answer;
//        
//        ArrayList<String[]> ans = new ArrayList<>();
//        
//        HashMap<String, String> hm = new HashMap<>();
//        
//        for(int i=0; i<record.length; i++) {
//        	String[] code = record[i].split(" ");
//        	
//        	// 새로운 사람인지 체크
//        	if(!hm.containsKey(code[1])) {
//        		hm.put(code[1], code[2]);
//        	}
//        	
//        	// 명령어 체크
//        	if(code[0].equals("Enter")) {
//        		hm.replace(code[1], code[2]);
//        		ans.add(new String[] {code[1], "님이 들어왔습니다."});
//        	}
//        	
//        	else if(code[0].equals("Leave")) {
//        		ans.add(new String[] {code[1], "님이 나갔습니다."});
//        	}
//        	
//        	else if(code[0].equals("Change")) {
//        		hm.replace(code[1], code[2]);
//        	}
//        }
//        answer = new String[ans.size()];
//        
//        for(int i=0; i< ans.size(); i++) {
//        	answer[i] = "";
//        	
//        	answer[i] += hm.get(ans.get(i)[0]);
//        	answer[i] += ans.get(i)[1];
//        	
//        	System.out.println(answer[i]);
//        }
//        return answer;
//    }
//}