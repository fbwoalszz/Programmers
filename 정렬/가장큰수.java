// 기준값.compareTo(비교대상)
// 기준값이 비교대상보다 더 크다면 자리를 바꿔준다.

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {             // [6, 10, 2]
        String answer = "";
        String[] arr = new String[numbers.length];      // arr[0], arr[1], arr[2]
        
        for(int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){   // s1=6, s2=10                      s1=10, s2=2
                return (s2+s1).compareTo(s1+s2);        // 106.compareTo(610) -> 그대로     210.compareTo(102) -> 바꿈
            }
        });
        
        if(arr[0].equals("0"))
            return "0";
        
        for(int i = 0; i < arr.length; i++)
            answer += arr[i];
        
        return answer;
    }
}