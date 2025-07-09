import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<quiz.length; i++) {
            int X = Integer.parseInt(quiz[i].split(" ")[0]) ;
            String oper = quiz[i].split(" ")[1];
            int Y = Integer.parseInt(quiz[i].split(" ")[2]);
            String eq = quiz[i].split(" ")[3];
            int Z = Integer.parseInt(quiz[i].split(" ")[4]);
            
            String result = "X";
            if( oper.equals("+") ) {
                if( X + Y == Z ) result = "O";
            } else {
                if( X - Y == Z ) result = "O";
            }
            
            answer[i] = result;
            
        }
        
        return answer;
    }
}