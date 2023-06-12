import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        long sum=0;
        int index =0;
        
        if(d[0]>budget) return 0;
        
        while(index<d.length){
            if(sum > budget){
                answer -=1;
                break;
            }else if(sum == budget){
                break;
            }
            sum += d[index];
            index+=1;
            answer++;
        }
        
        
        
        return answer;
    }
}
