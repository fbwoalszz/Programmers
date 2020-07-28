// 정답이 citations 배열 안에 있는게 아님.
// 정렬 후 맨 처음 H-Index가 성립한 순간만 고름.
// ex) 1 5 5 5 5 함정!
// H-Index = 4

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int num = citations.length;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < num; i++){
            int key = num - i;
            
            if(citations[i] >= key){
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}