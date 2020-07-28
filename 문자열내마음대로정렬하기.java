// 기준값.compareTo(비교대상)
// 기준값이 비교대상보다 더 크면 서로 바꾼다.

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                char c1 = s1.charAt(n);
                char c2 = s2.charAt(n);
                
                if(c1 == c2)
                    return s1.compareTo(s2);
                else
                    return c1 - c2;
            }
        });
        
        return strings;
    }
}