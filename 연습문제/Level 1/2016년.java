// 1월 = 0
// DAY_OF_MONTH = 현재 월의 날짜, Caeldnar.DAY_OF_MONTH와 동일.
// DAY_OF_WEEK = 현재 요일 일요일은 1, 토요일은 7

import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] weeks = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.MONTH, a-1);
        cal.set(Calendar.DATE, b);
        
        answer = weeks[cal.get(Calendar.DAY_OF_WEEK) - 1];  // weeks 배열과 맞추기 위해 -1.
        
        return answer;
    }
}