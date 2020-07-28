import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] man1 = {1, 2, 3, 4, 5};
        int[] man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = {0, 0, 0};
        int max = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < answers.length; i++){
            int a1 = i % 5;
            int a2 = i % 8;
            int a3 = i % 10;
            
            if(answers[i] == man1[a1])
                cnt[0]++;
            if(answers[i] == man2[a2])
                cnt[1]++;
            if(answers[i] == man3[a3])
                cnt[2]++;
        }
        
        max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        if(max == cnt[0])
            list.add(1);
        if(max == cnt[1])
            list.add(2);
        if(max == cnt[2])
            list.add(3);
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = (int)list.get(i);
        }
        
        return answer;
    }
}