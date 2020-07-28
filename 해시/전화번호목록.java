import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, String> map = new HashMap<String, String>();
        
        for(String num : phone_book)
            map.put(num, "1");                                  // ["12", "1"], ["123", "1"], ~~
        
        for(String num : phone_book){                           // num = 123
            for(int i = 1; i < num.length(); i++){
                if(map.containsKey(num.substring(0, i)))
                    return false;
            }
        }
        
        return true;
    }
}