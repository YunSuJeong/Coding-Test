import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i+1);
        }
        
        for(String c : callings) {
            int rank = map.get(c);
            
            players[rank-1] = players[rank-2];
            players[rank-2] = c;
            
            map.put(c, rank-1);
            map.put(players[rank-1], rank);
        }
        
        return players;
    }
}