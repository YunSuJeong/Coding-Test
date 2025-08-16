class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        boolean[] isPrime = new boolean[3000];
        for(int i=2; i*i<3000; i++) {
            for(int j=i*2; j<3000; j+=i) {
                if( !isPrime[j] ) isPrime[j] = true;
            }
        }

        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    int n = nums[i] + nums[j] + nums[k];
                    if( !isPrime[n] ) answer++;
                }
            }
        }

        return answer;
    }
}