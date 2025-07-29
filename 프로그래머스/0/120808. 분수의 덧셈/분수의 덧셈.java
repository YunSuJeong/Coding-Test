class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int num = numer1 * denom2 + numer2 * denom1;
        int dnom = denom1 * denom2;
        
        int gcd = gcd(num, dnom);
        
        answer[0] = num / gcd;
        answer[1] = dnom / gcd;
        return answer;
    }
    
    public int gcd(int a, int b) {
        if( a % b == 0 ) return b;
        else return gcd(b, a % b);
    }
}