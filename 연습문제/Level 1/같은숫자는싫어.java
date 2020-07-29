import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] answer = {};
        int tmp = 10;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != tmp)
                list.add(arr[i]);
            tmp = arr[i];
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}