class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sum = 1;        // 연속한 자연수들의 합
        int l = 1, r = 1;   // 연속한 자연수들의 가장 작은 수, 큰 수
        
        while( r <= n ) {
            if( sum == n ) {
                answer++;
                r++;
                sum += r;
            } else if( sum > n ) {
                sum -= l;
                l++;
            } else {
                r++;
                sum += r;
            }
        } 
        
        return answer;
    }
}