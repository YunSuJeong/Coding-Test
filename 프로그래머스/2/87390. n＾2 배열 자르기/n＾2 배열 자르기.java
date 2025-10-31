class Solution {
    public long[] solution(int n, long left, long right) {
        int len = (int)(right - left + 1);
        long[] answer = new long[len];
        
        for(int i=0; i<len; i++) {
            long num = left + i;
            answer[i] = Math.max(num/n, num%n) + 1;
        }
        return answer;
    }
}