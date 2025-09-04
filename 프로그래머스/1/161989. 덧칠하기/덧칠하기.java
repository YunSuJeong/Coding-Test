class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] arr = new boolean[n];
        for(int s : section) {
            arr[s-1] = true;
        }
        
        for(int i=0; i<n; ) {
            if( arr[i] ) {
                i += m;
                answer++;
            } else {
                i++;
            }
        }
        return answer;
    }
}