import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int lo = location;
        int size = priorities.length - 1;               // Arrays.sort()시 오름차순 한 마지막 요소가 가장 큰 수.
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int document : priorities)
            queue.add(document);
        
        Arrays.sort(priorities);                        // 우선순위 비교하기 위해 오름차순 정렬.
        
        while(!queue.isEmpty()){
            int poll = queue.poll();                    // 맨 밑에꺼 뽑아냄.
            
            if(poll == priorities[size - answer]){      // 방금 뽑은거 == 우선순위 제일 높은거
                answer++;
                lo--;
                
                if(lo < 0)
                    break;
            }
            else{
                queue.add(poll);                        // 뽑은거 다시 맨 위에 넣음.
                lo--;
                
                if(lo < 0)
                    lo = queue.size() - 1;
            }
        }
        
        return answer;
    }
}