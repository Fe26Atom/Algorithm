//package kkako;
//
//public class zipString {
//
//	
//	public static void main(String[] args) {
//		Solution solution = new Solution();
////		System.out.println(solution.solution("aabbaccc"));
////		System.out.println(solution.solution("ababcdcdababcdcd"));
////		System.out.println(solution.solution("abcabcdede"));
////		System.out.println(solution.solution("abcabcabcabcdededededede"));
////		System.out.println(solution.solution("xababcdcdababcdcd"));
//		
//	}
//}
//
//class Solution {
//	public int solution(String s ) {
//		int answer = s.length();
//		
//		for(int i=1; i<=s.length()/2; i++) {
//			int result = s.length();
//			int count = 1;
//			
//			for(int j=i; j+i<=s.length(); j+=i) {
//				// ���� ���
//				if(s.substring(j-i, j).equals(s.substring(j, j+i))) {
//					count++;
//					result -= i;
//				}
//				// �ٸ� ���
//				else {
//					if(count!=1)
//						result += (""+count).length();
//					count=1;
//				}
//			}
//			// ������ ó��
//			if(count!=1)
//				result += (""+count).length();
//			System.out.println(i + " " + result);
//			answer = Math.min(answer, result);
//		}
//		
//		return answer;
//	}
//}