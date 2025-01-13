class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        //배열1의 열인덱스 x 배열2의 행 인덱스
        //i는 행, j는 열, k를 반복하며 순회해서 행렬곱셈 구현 
        for(int i=0; i<arr1.length;i++){
            for(int j=0;j<arr2[0].length;j++){
                for(int k=0;k<arr1[0].length;k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
  
    return answer;
    }
}
