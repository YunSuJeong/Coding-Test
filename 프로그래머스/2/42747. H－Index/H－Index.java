import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int len = citations.length;
        int[] cnt = new int[len+1];     // i번 인용된 논문의 개수
        int[] dp = new int[len+1];      // i번 이상 인용된 논문의 개수
        
        for(int c : citations) {
            if( c <= len ) cnt[c]++;
        }

        dp[0] = len;
        for(int i=0; i<len; i++) {
            dp[i+1] = dp[i] - cnt[i];
        }
        
        for(int i=len; i>=0; i--) {
            if( dp[i] >= i ) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}