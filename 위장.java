// 무조건 하나는 입어야 하므로, 아무것도 입지 않은 경우만 빼주면 된다. ( - 1)
// ex) 안경이 2개 : 아무것도 안씀, 첫번째 안경, 두번째 안경.
// ex) 모자가 1개 : 아무것도 안씀, 첫번째 모자.
// 도출 식 : 종류 갯수 + 1  //  옷들의 조합 : 서로 곱.
// 결국 : {(종류1 갯수 + 1) x (종류2 갯수 + 1) x ....} - 1

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String[] cloth : clothes)
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);        // cloth[1] : 의상 종류.
        
        for(String cloth : map.keySet())
            answer *= map.get(cloth) + 1;                                // {(종류1 갯수 + 1) x (종류2 갯수 + 1) x ....}
        
        return answer - 1;                                               // 위의 식 - 1
    }
}