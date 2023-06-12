import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int index_a =0;
        int index_b =0;
        while(index_b<B.length){
            if(B[index_b]>A[index_a]){
                answer++;
                index_a++;
            }
            index_b++;
        }
        
        
        return answer;
    }
}
