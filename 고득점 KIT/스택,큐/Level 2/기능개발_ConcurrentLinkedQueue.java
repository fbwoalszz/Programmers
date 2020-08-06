import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int prevProg = 0;
        int numProg = 1;
        
        Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < progresses.length; i++){
            queue.add(
            (100 - progresses[i]) % speeds[i] == 0 ? 
            (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1
            );
        }
        
        prevProg = queue.poll();
        
        while(!queue.isEmpty()){
            int currentProg = queue.poll();
            
            if(prevProg >= currentProg)
                numProg++;
            else{
                list.add(numProg);
                numProg = 1;
                prevProg = currentProg;
            }
        }
        
        list.add(numProg);
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}