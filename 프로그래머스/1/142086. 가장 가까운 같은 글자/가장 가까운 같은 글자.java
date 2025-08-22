import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        // 1) 2중 for문
        /*for(int i=0; i<s.length(); i++) {
            int idx = i-1;
            while( idx >= 0 ) {
                if( s.charAt(idx) == s.charAt(i) ) break;
                idx--;
            }
            answer[i] = idx < 0 ? idx : i - idx;
        }*/
        
        // 2) 알파벳 별 마지막 출현 위치 상태관리
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        
        for(int i=0; i<s.length(); i++) {
            int j = s.charAt(i) - 97;
            answer[i] = idx[j] < 0 ? idx[j] : i - idx[j];
            idx[j] = i;
        }
        
        return answer;
    }
}