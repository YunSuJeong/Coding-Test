import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();     // 제품의 위치
        for(int i=0; i<want.length; i++) map.put(want[i], i);
        
        int[] allDC = new int[want.length];             // 10일 동안 할인받은 제품 개수
        
        for(int i=0; i<=discount.length-10; i++) {
            boolean isDC = true;
            Arrays.fill(allDC, 0);
            
            for(int j=0; j<10; j++) {
                // 할인하는 제품이 구매하려는 제품에 해당하지 않는 경우
                if( !map.containsKey(discount[i+j]) ) {
                    isDC = false;
                    break;
                }
                
                int idx = map.get(discount[i+j]);
                allDC[idx]++;
            }
            
            if( !isDC ) {
                continue;
            } else {
                for(int j=0; j<number.length; j++) {
                    if( allDC[j] != number[j] ) {
                        isDC = false;
                        break;
                    }
                }
                if( isDC ) answer++;
            }
        }
        
        return answer;
    }
}