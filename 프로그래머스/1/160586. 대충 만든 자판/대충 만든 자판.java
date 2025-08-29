import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++) {
            int count = 0, min = 0;
            for(int j=0; j<targets[i].length(); j++) {
                min = Integer.MAX_VALUE;
                char c = targets[i].charAt(j);
                // 문자c의 휴대폰 자판 최소 클릭 횟수 구하기
                for(String key : keymap) {
                    if( key.indexOf(c) >= 0 ) min = Math.min(min, key.indexOf(c)+1);  
                }
                if( min == Integer.MAX_VALUE ) break;           // 어디에도 없는 문자면 break;
                count += min;
            }
            answer[i] = count > 0 && min != Integer.MAX_VALUE ? count : -1;
        }
        
        return answer;
    }
}