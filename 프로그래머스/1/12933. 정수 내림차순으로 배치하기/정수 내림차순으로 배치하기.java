import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] arr = Long.toString(n).toCharArray();
        
        Arrays.sort(arr);
        for(int i=arr.length-1; i>=0; i--) {
            answer = answer * 10 + (arr[i]-'0');
        }
        return answer;
    }
}