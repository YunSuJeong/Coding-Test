import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int m : moves) {
            for(int i=0; i<board.length; i++) {
                if( board[i][m-1] > 0 ) {
                    if( !stack.isEmpty() && stack.peek() == board[i][m-1] ) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(board[i][m-1]);
                    }
                    board[i][m-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}