import java.util.*;

class Solution {
    
    public int[] first = {1, 2, 3, 4, 5};
    public int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    public int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if( first[i%5] == answers[i] ) score[0]++;
            if( second[i%8] == answers[i] ) score[1]++;
            if( third[i%10] == answers[i] ) score[2]++;
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        for(int i=0; i<3; i++) {
            if( score[i] == max ) answer.add(i+1);
        }
        
        return answer;
    }
}