import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.length; i++){
            if((arr[i] % divisor) == 0){
                list.add(arr[i]);
                cnt++;
            }
        }
        
        if(cnt == 0)
            list.add(0, -1);
        
        answer = new int[list.size()];
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);            
        
        return answer;
    }
}