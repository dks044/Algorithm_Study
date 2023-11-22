import java.util.*;
class Solution {
    //더이상 검사안하게
    private static final int STEAL_CHECK = 10000;
    private static final int SPORTS = 20000;
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //여분갖고있는 애가 도난당했을떄 처리
        for(int i=0;i<reserve.length;i++){
            for(int j=0;j<lost.length;j++){
                if(reserve[i] == lost[j]){
                    answer++;
                    reserve[i] = STEAL_CHECK;
                    lost[j] = STEAL_CHECK;
                    break;
                }
            }
        }
        
        for(int i=0;i<reserve.length;i++){
            if(reserve[i] != STEAL_CHECK){
                for(int j=0;j<lost.length;j++){
                    if(lost[j] == reserve[i]+1 || lost[j] == reserve[i]-1){
                        answer++;
                        lost[j] = SPORTS;
                        break;
                    }
                }
            }else continue;
        }
        
        return answer;
    }
}
