// char[] arrChar = s.toCharArray();
// Arrays.sort(arrChar, Collections.reverseOrder());
// 위 처럼, byte, char, double, short, long, int ,float 같은
// Primitive Type의 배열에는 적용할 수 없음.

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer;
        String[] arr = s.split("");
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        answer = String.join("", arr);
        
        return answer;
    }
}