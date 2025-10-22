class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int[] cnt = new int[10000001];          // 종류 i인 과일 개수
        int[] typeCnt = new int[100001];        // 과일 개수가 같은 과일들의 종류
        
        for(int t : tangerine) {
            cnt[t]++;
        }
        
        for(int c : cnt) {
            typeCnt[c]++;
        }
        
        int i = 100000;
        while( k > 0 && i >= 0 ) {
            if( typeCnt[i] == 0 ) {     // 과일이 없을 때
                i--;
                continue;
            }
            
            k -= i;                     // 같은 과일의 수를 뺀다.
            typeCnt[i]--;               // 종류도 한가지 뺀다. (어떤 종류인지는 알 필요가 없다.)
            
            answer++;
        }
        
        return answer;
    }
}