class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int n = attacks[attacks.length-1][0];
        int idx = 0, count = 0;
        
        for(int i=1; i<=n; i++) {
            if( answer <= 0 ) break;
            
            if( attacks[idx][0] == i ) {
                count = 0;
                answer -= attacks[idx][1];
                idx++;
            } else {
                count++;
                answer += bandage[1];
                
                if( count == bandage[0] ) {
                    answer += bandage[2];
                    count = 0;
                }
                
                if( answer > health ) answer = health;
            }
        }
        
        return answer <= 0 ? -1 : answer ;
    }
}