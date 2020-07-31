// 일반적인 우선순위 큐
// PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

// 우선순위를 높은 숫자 위주로 변경할 시 -> 내림차순 정렬
// PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reversOrder());

// 근데 { 2, 5, 4, 1, 3 } 을 우선순위 큐에 넣으면 { 5, 4, 3, 2, 1 }이 아닌 { 5, 3, 4, 1, 2 } 이다.
// 왜냐?        우선순위 큐는 힙으로 구현되어있기 때문.  ->  힙 삽입 참조.
// 하지만 실제 동작은 { 5, 4, 3, 2, 1 } 로 동작한다.
// 그 이유는 MAX HEAP에서 데이터 삭제 과정을 참고!
// https://makemethink.tistory.com/136


import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int document : priorities)
            queue.add(document);
        
        System.out.println(queue);
        
        while(!queue.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == (int)queue.peek()){
                    if(i == location)
                        return answer;
                    
                    queue.poll();
                    answer++;
                }
            }
        }
        
        return answer;
    }
}