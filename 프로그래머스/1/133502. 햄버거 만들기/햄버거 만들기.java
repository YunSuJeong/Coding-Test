import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        int[] burger = {1, 2, 3, 1};
        int[] check = new int[4];
        Stack<Integer> stack = new Stack<>();
        
        boolean isBurger = true;
        for(int i=0; i<=ingredient.length; i++) {
            if( stack.size() >= 4 ) {
                isBurger = true;
                for(int j=3; j>=0; j--) {
                    check[j] = stack.pop();
                }
                
                for(int j=0; j<4; j++) {
                    if( check[j] != burger[j] ) {
                        isBurger = false;
                        break;
                    }
                }
                
                if( isBurger ) {
                    answer++;
                } else {
                    for(int j=0; j<4; j++) {
                        stack.push(check[j]);
                    }
                }
            }
            
            if( i < ingredient.length ) stack.push(ingredient[i]);
        }
        
        return answer;
    }
}
