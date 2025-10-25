import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int l = words.length;
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        for(int i=1; i<l; i++) {
            if( words[i-1].length() > 0 
               && words[i].length() > 0 
               && (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || set.contains(words[i]))
              ) {
                answer[0] = (i+1) % n == 0 ? n : (i+1) % n;
                answer[1] = (i+1) % n == 0 ? (i+1) / n : (i+1) / n + 1;
                break;
            }
            set.add(words[i]);
        }
        System.out.println(set.toString());
        return answer;
    }
}