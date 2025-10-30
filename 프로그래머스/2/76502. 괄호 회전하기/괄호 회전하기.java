import java.util.*;

class Solution {
    
    String str = "";
    
    public int solution(String s) {
        int answer = 0;
        
        str = s;
        for(int i=0; i<s.length(); i++) {
            if( isPair(i) ) answer++;
        }
        
        return answer;
    }
    
    public boolean isPair(int n) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt((n+i)%str.length());
            if( stack.isEmpty() || c == '(' || c == '[' || c == '{' ) {
                stack.push(c);
            } else {
                if( (c == ')' && stack.peek() == '(')
                  || (c == ']' && stack.peek() == '[')
                  || (c == '}' && stack.peek() == '{') ) stack.pop();
            }
        }
        
        if( stack.isEmpty() ) return true;
        return false;
    }
}