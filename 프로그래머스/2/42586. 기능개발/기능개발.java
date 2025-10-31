import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int max = (100-progresses[0]) / speeds[0];
        if( (100-progresses[0]) % speeds[0] > 0 ) max++;
        
        int i = 1, cnt = 1;
        while( i < progresses.length ) {
            int day = (100-progresses[i]) / speeds[i];
            if( (100-progresses[i]) % speeds[i] > 0 ) day++;
            
            if( max < day ) {
                max = day;
                answer.add(cnt);
                cnt = 0;
            }
            cnt++;
            i++;
        }
        answer.add(cnt);
        
        return answer;
    }
}