class Solution {
    static int answer = -1;
    
    public static int solution(int N, int number) {
        calc(N, number, 0, 0);
        
        return answer;
    }
    
    public static void calc(int n, int number, int cnt, int accum){
        int num = n;
        
        
        if(cnt > 8){
            answer = -1;
            return;
        }
        
        if(accum == number){
            if(answer == -1 || answer > cnt)
                answer = cnt;
            return;
        }
        
        for(int i = 1; i < (9 - cnt); i++){
            calc(n, number, cnt + i, accum + num);
            calc(n, number, cnt + i, accum - num);
            calc(n, number, cnt + i, accum / num);
            calc(n, number, cnt + i, accum * num);
            
            num = num * 10 + n;
        }
    }
    
}