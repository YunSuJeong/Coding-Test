class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long ternary = 0;
        long multi = 1;
        
        // 3진법 변환 후 뒤집기
        while( n > 0 ) {
            ternary = ternary * 10 + n % 3;
            n /= 3;
        }
        
        // 10진법 변환
        while( ternary > 0 ) {
            answer += ternary % 10 * multi;
            multi *= 3;
            ternary /= 10;
        }
        
        return answer;
    }
}