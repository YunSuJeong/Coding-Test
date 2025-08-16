class Solution {
    public int solution(int n) {
        int answer = n-1;
        
        boolean[] arr = new boolean[n+1];       // 소수 판별 배열(F:소수o, T:소수x)
        for(int i=2; i*i<=n; i++) {
            for(int j=i*2; j<=n; j+=i) {
                if( !arr[j] ) {
                    arr[j] = true;
                    answer--;
                }
            }
        }
        
        return answer;
    }
}