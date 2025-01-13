import java.util.*;
class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        for(int a=0;a<n-2;a++){
            for(int b=a+1;b<n-1;b++){
                for(int c=b+1;c<n;c++){
                    if(number[a]+number[b]+number[c]==0) answer++;
                }
            }
        }
        
        return answer;
    }
}
