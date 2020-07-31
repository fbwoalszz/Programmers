import java.util.*;

class Solution {
    class Finance{
        int price;
        int time;
        
        Finance(int price, int time){
            this.price = price;
            this.time = time;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Finance> stack = new Stack<Finance>();
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && (stack.peek().price > prices[i])){
                Finance finance = stack.pop();
                answer[finance.time] = i - finance.time;
            }
            
            stack.push(new Finance(prices[i], i));
        }
        
        while(!stack.isEmpty()){
            Finance finance = stack.pop();
            answer[finance.time] = prices.length - finance.time - 1;
        }
        
        return answer;
    }
}