import java.util.*;

class Solution {
    public String solution(String s) {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        
        for(String n : s.split(" ") ) {
            long num = Integer.parseInt(n);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return String.format("%s %s", min, max);
    }
}