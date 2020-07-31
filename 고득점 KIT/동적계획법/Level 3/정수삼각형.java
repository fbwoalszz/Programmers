// 동적계획법 : 간단히 말해 이전에 구한 값을 다시 가져와 계산하는 방법.
// 반복적으로 메소드를 불러오는 횟수를 줄이고 전에 구한 값을 저장하여 새로운 답을 구하는 것.

// 가운데 있는 것들은 중복되어 계산되기 때문에 시간 초과가 될 우려가 있음.
// ex) ((7 + 3) + 1), ((7 + 8) + 1) 1은 중복되어 2번 계산되는데,
// 10과 15중 큰 수를 구별하여 큰 수에만 더해주면 연산 과정이 한번 줄어든다!

// 제일 먼저 양쪽 끝의 합들부터 구함.
// 그 값들을 가져와 대소 구별하여 가운데 값을 더해주면 됨.


class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] arr = new int[triangle.length][triangle.length];
        
        arr[0][0] = triangle[0][0];                             // 루트 노드는 동일함.
        
        for(int i = 1; i < triangle.length; i++){               // 양쪽 끝의 합을 각각 구함.
            arr[i][0] = arr[i - 1][0] + triangle[i][0];
            arr[i][i] = arr[i - 1][i - 1] + triangle[i][i];
        }
        
        /**** 동적계획법 ****/
        for(int i = 2; i < triangle.length; i++){               // 위에서 구했던 값들을 가져와 가운데 것들을 더해줌.
            for(int j = 1; j < i; j++)
                arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + triangle[i][j];
        }
        
        /**** 최대값 반환 ****/
        for(int i = 0; i < arr.length; i++)
            answer = Math.max(answer, arr[arr.length - 1][i]);
        
        return answer;
    }
}