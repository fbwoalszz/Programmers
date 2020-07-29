class Solution {
    public int solution(int n) {                        // n=9
        int answer = 0;
        int root = 0;
        boolean[] sosu = new boolean[n+1];              // 10개 만듦.
        
        for(int i = 2; i <= n; i++)
            sosu[i] = true;
        
        root = (int)Math.sqrt(n);                       // root=3
        
        for(int i = 2; i <= root; i++){                 // i=2                                              i=3
            if(sosu[i] == true){                        // sosu[2]=true                                     sosu[3]=true
                for(int j = i; i * j <= n; j++)         // j=2  4<=9        k=3  6<=9       j=4  8<=9       j=3  9<=9
                    sosu[i*j] = false;                  // sosu[4]=false    sosu[6]=false   sosu[8]=false   sosu[9]=false
            }
        }
        
        for(int i = 2; i <= n; i++){
            if(sosu[i] == true)
                answer++;
        }
        
        return answer;
    }
}