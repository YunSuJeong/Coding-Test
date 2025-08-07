class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = gcd * n / gcd * m / gcd;
        
        int[] answer = {gcd, lcm};

        return answer;
    }
    
    public int gcd(int a, int b) {
        if( a % b == 0 ) return b;
        else return gcd(b, a%b);
    }
}