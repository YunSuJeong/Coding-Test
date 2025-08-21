import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        for(int i=0; i<s.length(); i++) {
            char alpha = s.charAt(i);
            if( alpha == ' ' ) {
                sb.append(" ");
                idx = 0;
            } else {
                if( idx % 2 == 0 ) sb.append(Character.toUpperCase(alpha));
                else sb.append(Character.toLowerCase(alpha));
                idx++;
            }
        }
        
        return sb.toString();
    }
}