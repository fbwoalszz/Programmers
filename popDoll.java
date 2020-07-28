import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int move : moves){
            int section = move - 1;
            
            if(board[board.length - 1][section] != 0){
                for(int j = 0; j < board.length; j++){
                    int doll = board[j][section];
                    
                    if(doll == 0)
                        continue;
                    else{
                        if(isDollPopped(stack, doll))
                            answer += 2;
                        board[j][section] = 0;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private boolean isDollPopped(Stack<Integer> stack, int doll){
        if(!stack.isEmpty() && (stack.peek() == doll)){
            stack.pop();
            return true;
        }
        
        stack.push(doll);
        
        return false;
    }
}