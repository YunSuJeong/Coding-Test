import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String nm : completion) {
            map.put(nm, map.getOrDefault(nm, 0)+1);
        }
        
        for(String nm : participant) {
            // 완주자 명단에 없는 사람이거나, 명단에는 있으나 동명이인이 먼저 완주한 경우
            if( !map.containsKey(nm) || map.get(nm) <= 0 ) {
                answer = nm;
                break;
            }
            map.put(nm, map.get(nm)-1);
        }
        
        return answer;
    }
}