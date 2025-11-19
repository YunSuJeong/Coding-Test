import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int t : topping) {
            map.put(t, map.getOrDefault(t,0)+1);
            set2.add(t);
        }
        
        for(int i=0; i<topping.length-1; i++) {
            int n = topping[i];
            if( map.get(n) > 0 ) {
                set1.add(n);
                map.put(n, map.get(n)-1);
            }
            if( map.get(n) == 0 ) set2.remove(n);
            
            if( set1.size() == set2.size() ) answer++;
        }
        
        return answer;
    }
}