import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        
        for(int i=1; i<=len; i++) {
            int sum = 0;
            for(int j=0; j<i; j++) {
                sum += elements[j];
            }
            
            // 슬라이딩 윈도우 방식
            for(int j=0; j<len; j++) {
                sum = sum - elements[j] + elements[(i+j)%len];
                set.add(sum);
            }
        }
        return set.size();
    }
}