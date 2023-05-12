import java.util.*;
class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int sum =0;
        answer[0] = total/num;
        sum +=answer[0];
        for(int i=1;i<answer.length;i++){
            answer[i]=answer[i-1]+1;
            sum+= answer[i];
        }
        int temp = sum-total; //3 | 10 (중간값에서 +1씩한 sum에서 total을 뺸값.)
        int temp2 = temp/num; //1 | 2  (뺸값에서 수의 갯수만큼 나눔.)
        System.out.println(temp);
        //이제 나눈값을 각 배열의 수마다 뺼셈을 해주면 정답이다.
        for(int i=0;i<answer.length;i++){
            answer[i] -= temp2;
        }
        Arrays.sort(answer);
        
        
        return answer;
    }
}
