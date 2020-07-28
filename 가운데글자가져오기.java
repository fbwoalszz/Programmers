class Solution {
    public String solution(String s) {
        String answer = "";
        int odd = (s.length() / 2) + 1;
        int even = s.length() / 2;
        
        if(s.length() % 2 == 0)
            answer = s.substring(even - 1, odd);
        else
            answer = s.substring(even, odd);
        
        return answer;
    }
}