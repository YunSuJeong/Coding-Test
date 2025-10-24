import java.util.Arrays;
class Solution {
    public int solution(int[] arr) {        
        int GCD = 1;
        
        for(int i=0; i<arr.length-1; i++) {
            int n = 0;
            for(int j=i+1; j<arr.length; j++) {
                n = gcd(arr[i], arr[j]);
                GCD *= n;
                
                for(int k=0; k<arr.length; k++) {
                    if( arr[k] % n == 0 ) arr[k] /= n;
                }
            }
        }
        
        int answer = GCD;
        for(int i=0; i<arr.length; i++) {
            answer *= arr[i];
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if( b == 0 ) return a;
        else return gcd(b, a%b);
    }
}