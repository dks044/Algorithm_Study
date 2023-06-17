import java.util.*;
class Solution {
    public static boolean factor(int n){
        if(n <= 2) return true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i ==0) return false;
        }
        return true;
    }
    
    public int solution(int n) {
        int answer = 0;
        for(int i=2;i<=n;i++){
            if(factor(i)){
                answer++;
            }
        }
        
        
        return answer;
    }
}
