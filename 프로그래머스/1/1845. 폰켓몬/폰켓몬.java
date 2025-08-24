import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int N = nums.length;
        
        for(int n : nums) {
            set.add(n);
        }
        
        return set.size() >= N/2 ? N/2 : set.size();
    }
}