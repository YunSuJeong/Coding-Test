import java.util.*;

class Solution {
    public Set<Integer> solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        return set;
    }
}