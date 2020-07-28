class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        if(s.length() == 4 || s.length() == 6){
            answer = true;
            
            for(int i = 0; i < s.length(); i++){
                char check = s.charAt(i);
            
                if(check < 48 || check > 58)
                  answer = false;
             }
        }
        
        return answer;
    }
}