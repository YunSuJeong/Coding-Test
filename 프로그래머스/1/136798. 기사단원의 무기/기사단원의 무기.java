class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            int div = divisor(i);           // 약수개수 구하기
            
            if( div > limit ) div = power;
            answer += div;
        }
        
        return answer;
    }
    
    public int divisor(int n) {
        int count = 0;
        for(int i=1; i*i<=n; i++) {
            if( n % i == 0 ) {
                if( i == n / i ) count++;
                else count += 2;
            }
        }
        return count;
    }
}