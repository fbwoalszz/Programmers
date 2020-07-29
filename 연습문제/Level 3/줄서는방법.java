// 1부터 n까지의 숫자를 제거하면서 그때그때의 순서를 알아야 하니 LinkedList 사용.
// n이 주어질 때 모든 경우의 수 는 n!

// if n = 4
// [ 1, 2, 3, 4 ]
// [ 1, 2, 4, 3 ]
// [ 1, 3, 2, 4 ]
// [ 1, 3, 4, 2 ]
// [ 1, 4, 2, 3 ]
// [ 1, 4, 3, 2 ]
// n=4일 때, 1로 시작하는 6조각, 2시작 6조각, 3시작 6조각, 4시작 6조각.
// 4!=24 을 n=4으로 나누면 6. 6개가 1 slice. 총 4 slice.

// 1~6 -> 1 / 7~12 -> 2 / 13~18 -> 3 / 19~24 -> 4  =>  일반 숫자.
// 1씩 빼주면
// 0~5 -> 0 / 6~11 -> 1 / 12~17 -> 2 / 18~23 -> 3  =>  인덱스용.
// k=4라면, ((k-1) / slice) = 0  ->  list 0번째는 1.
// 1이 앞에오는 slice 하나만 보면 됨.  ->  total은 slice가 됨.

// 2로 시작하는 2조각, 3시작 2조각, 4시작 2조각.  반복.


import java.util.LinkedList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long total = factorial(n);
        int idx = 0;
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for(int i = 1; i <= n; i++)                 // 1부터 n까지 list에 담음.
            list.add(i);
        
        while(n > 1){
            long slice = total / n;
            int current = (int)((k-1) / slice);
            
            answer[idx] = list.remove(current);
            k = k % slice;
            
            if(k == 0)
                k = slice;
            
            total = slice;
            idx++;
            n--;
        }
        
        answer[idx] = list.remove(0);
        
        return answer;
    }
    
    public long factorial(int n ){
        long result = 1;
        
        for(int i = 2; i <= n; i++)
            result *= i;
        
        return result;
    }
}