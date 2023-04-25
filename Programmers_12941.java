import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<Integer> b_arr = new ArrayList<>();
        for(int i=0;i<B.length;i++){
            b_arr.add(B[i]);
        }
        Collections.reverse(b_arr);
        for(int i=0;i<A.length;i++){
            answer += A[i]*b_arr.get(i);
        }
        

        return answer;
    }
}
