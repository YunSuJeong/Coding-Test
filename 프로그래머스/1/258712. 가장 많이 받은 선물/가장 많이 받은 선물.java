import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int l = friends.length;
        
        int[][] give = new int[l][l];       // 선물 준 적이 있는지
        int[][] arr = new int[l][2];                // 주고 받은 선물 개수
        int[] count = new int[l];                   // 다음달 받을 예상 선물 개수
        
        Map<String, Integer> map = new HashMap<>();     // name to index
        for(int i=0; i<l; i++) {
            map.put(friends[i], i);
        }
        
        for(String g : gifts) {
            int A = map.get(g.split(" ")[0]);
            int B = map.get(g.split(" ")[1]);
            
            give[A][B]++;
            arr[A][0]++;
            arr[B][1]++;
        }
        
        for(int i=0; i<l; i++) {
            for(int j=0; j<l; j++) {
                if( (give[i][j] > 0 || give[j][i] > 0) && give[i][j] != give[j][i] ) {
                    if( give[i][j] > give[j][i] ) count[i]++;
                } else if( !(give[i][j] == 0 && give[i][j] > 0) || (give[i][j] == give[j][i]) ) {
                    int scoreA = arr[i][0] - arr[i][1];
                    int scoreB = arr[j][0] - arr[j][1];
                    if( scoreA > scoreB ) count[i]++;
                }
            }
        }

        for(int i=0; i<l; i++) {
            answer = Math.max(answer, count[i]);
        }
        return answer;
    }
}