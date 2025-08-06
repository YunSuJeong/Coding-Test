import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        
        for(int a : arr) {
            if( a % divisor == 0 ) answer.add(a);
        }
        
        if( answer.isEmpty() ) answer.add(-1);
        
        Collections.sort(answer);       // 정렬
        
        return answer;
    }
}