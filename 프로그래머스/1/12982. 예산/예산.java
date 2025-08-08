import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        // 오름차순 정렬 후, 적은 금액부터 지원
        Arrays.sort(d);
        
        for(int item : d) {
            if( item <= budget ) {
                answer++;
                budget -= item;
            }
        }
        
        return answer;
    }
}