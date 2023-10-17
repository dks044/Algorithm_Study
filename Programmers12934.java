import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        if(Math.sqrt(n) %1 !=0) answer = -1;
        else{
            answer = (long)Math.sqrt(n)+1;
            answer *= answer;
        }
        return answer;
    }
}
