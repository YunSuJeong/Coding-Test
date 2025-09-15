import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        Map<Character, int[]> map = new HashMap<>();
        map.put('1', new int[] {0, 0});
        map.put('2', new int[] {0, 1});
        map.put('3', new int[] {0, 2});
        map.put('4', new int[] {1, 0});
        map.put('5', new int[] {1, 1});
        map.put('6', new int[] {1, 2});
        map.put('7', new int[] {2, 0});
        map.put('8', new int[] {2, 1});
        map.put('9', new int[] {2, 2});
        map.put('0', new int[] {3, 1});
        map.put('*', new int[] {3, 0});
        map.put('#', new int[] {3, 2});
        
        char l = '*', r = '#';
        for(int n : numbers) {
            char c = (char)(n+48);
            if( n == 1 || n == 4 || n == 7) {
                sb.append("L");
                l = c;
            } else if( n == 3 || n == 6 || n == 9 ) {
                sb.append("R");
                r = c;
            } else {        // n = 2, 5, 8, 0
                int distL = Math.abs(map.get(l)[0] - map.get(c)[0]) + Math.abs(map.get(l)[1] - map.get(c)[1]);
                int distR = Math.abs(map.get(r)[0] - map.get(c)[0]) + Math.abs(map.get(r)[1] - map.get(c)[1]);
                
                if( distL < distR ) {
                    sb.append("L");
                    l = c;
                } else if( distL > distR ) {
                    sb.append("R");
                    r = c;
                } else {
                    // 왼손, 오른손 거리가 같은 경우, 주 손을 사용
                    if( hand.equals("left") ) {
                        sb.append("L");
                        l = c;
                    } else {
                        sb.append("R");
                        r = c;
                    }
                }
            }
        }
        
        return sb.toString();
    }
}