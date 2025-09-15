class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
       for(int i=left; i<=right; i++) {
           int cnt = divisor(i);
           if( cnt % 2 == 0 ) answer += i;
           else answer -= i;
       }
        
        return answer;
    }
    
    public int divisor(int n) {
        int count = 0;
        
        for(int i=1; i<=n; i++) {
            if( n % i == 0 ) count++;
        }
        
        return count;
    }
}