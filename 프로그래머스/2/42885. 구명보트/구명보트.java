import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int l = 0, r = people.length-1;
        while( l < r ) {
            if( people[l] + people[r] <= limit ) {
                l++;
                r--;
            } else {
                r--;
            }
            answer++;
        }
        
        if( l == r ) answer++;      // 마지막 혼자 남은 사람
        
        return answer;
    }
}