import java.util.*;

class Solution {
    
    Set<String> set = new HashSet<>();
    String[] arr = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        combi(0, "");
        
        for(String word : babbling) {
            if( set.contains(word) ) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void combi(int depth, String str) {
        if( depth == 4 ) {
            set.add(str);
            return;
        }
        
        for(int i=0; i<4; i++) {
            if( str.indexOf(arr[i]) < 0 ) combi(depth+1, str + arr[i]);
        }
        combi(depth+1, str);
    }
}