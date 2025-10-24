class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = pow(n);                // 진행되는 총 라운드 수
        int m = n / 2;                      // 현재 라운드의 중간값
        
        while( !(Math.min(a,b) <= m && Math.max(a, b) > m) ) {       // 중간
            n /= 2;
            if( a <= m && b <= m ) {
                m -= n/2;
            } else {
                m += n/2;
            }
            answer--;
        }
        
        return answer;
    }
    
    public int pow(int num) {
        int pow = 0;
        while( num > 1 ) {
            num /= 2;
            pow++;
        }
        return pow;
    }
}