import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);    //  getOrDefault(String, int) : if player exists, get value. Not exists, get 0.
        
        for(String player : completion){
            map.put(player, map.get(player) - 1);
        }
        
        for(String player : map.keySet()){
            if(map.get(player) != 0)
                answer = player;
        }
            
            
        
        return answer;
    }
}