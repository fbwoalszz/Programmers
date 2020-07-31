import java.util.Stack;

class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<int[]> stack = new Stack<int[]>();
        
        for(int i = 0; i < heights.length; i++){
            int result = 0;
            
            while(!stack.isEmpty()){
                int[] stackTop = stack.peek();              //          {1, 6}          {2, 9}
                
                if(stackTop[1] > heights[i]){               //          6 > 9           9 > 5
                    result = stackTop[0];                   //                          2
                    break;
                }                                           //          {1, 6} pop
                else
                    stack.pop();
            }
            
            answer[i] = result;                             // 0        0, 0            0, 0, 2
            stack.push(new int[] {i + 1, heights[i]});      // {1, 6}   {2, 9}
        }
        
        return answer;
    }
}