class Solution {
    public int solution(int n) {
        int answer = n + 1;
        
        int cnt = toBinary(n);
        while( true ) {
            if( toBinary(answer) == cnt ) break;
            answer++;
        }
        
        return answer;
    }
    
    public int toBinary(int num) {
        int one = 0;
        
        while( num > 0 ) {
            if( num % 2 == 1 ) one++;
            num /= 2;
        }
        
        return one;
    }
}