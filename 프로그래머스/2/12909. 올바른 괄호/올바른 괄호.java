import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if( c == '(' ) {
                stack.push(1);
            } else {
                if( stack.isEmpty() ) {
                    return false;
                } else { 
                    stack.pop();
                }
            }
        }
        
        if( stack.isEmpty() ) answer = true;

        return answer;
    }
}