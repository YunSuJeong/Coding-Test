import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        
        Arrays.sort(arr);       // 오름차순 정렬 후
        
        // 역순으로 조합
        for(int i=arr.length-1; i>=0; i--) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}