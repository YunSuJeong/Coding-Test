import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        Arrays.sort(mats);
        
        Lay: for(int i=mats.length-1; i>=0; i--) {
            for(int j=0; j<park.length-mats[i]+1; j++) {
                for(int k=0; k<park[0].length-mats[i]+1; k++) {
                    if( isLay(j, k, mats[i], park) ) {
                        answer = mats[i];
                        break Lay;
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean isLay(int r, int c, int n, String[][] park) {
        boolean flag = true;
        
        BREAK: for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 범위 벗어 나거나, 이미 사람이 있다면 돗자리 깔지 못함
                if( !(r+i < park.length && c+j < park[0].length && park[r+i][c+j].equals("-1")) ) {
                    flag = false;
                    break BREAK;
                }
            }
        }
        
        return flag;
    }
}