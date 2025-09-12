import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for(int i=0; i<survey.length; i++) {
            int c = choices[i];
            char type;
            if( c < 4 ) {
                type = survey[i].charAt(0);
                if( c == 1 ) {
                    map.put(type, map.get(type)+3);
                } else if( c == 2 ) {
                    map.put(type, map.get(type)+2);
                } else {
                    map.put(type, map.get(type)+1);
                }
            } else if( c > 4 ) {
                type = survey[i].charAt(1);
                if( c == 5 ) {
                    map.put(type, map.get(type)+1);
                } else if ( c == 6 ) {
                    map.put(type, map.get(type)+2);
                } else {
                    map.put(type, map.get(type)+3);
                }
            }
        }

        sb.append(map.get('R') == map.get('T') ? 'R' : map.get('R') > map.get('T') ? 'R' : 'T');
        sb.append(map.get('C') == map.get('F') ? 'C' : map.get('C') > map.get('F') ? 'C' : 'F');
        sb.append(map.get('J') == map.get('M') ? 'J' : map.get('J') > map.get('M') ? 'J' : 'M');
        sb.append(map.get('A') == map.get('N') ? 'A' : map.get('A') > map.get('N') ? 'A' : 'N');
        
        return sb.toString();
    }
}