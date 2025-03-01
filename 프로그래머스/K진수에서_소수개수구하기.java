import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        boolean isZero = false;
        for(String ssibal : 진법찾는놈(n,k).split("0")){
            if(!ssibal.isEmpty()){
                if(나는소수다(Long.parseLong(ssibal))) answer++;    
            }
        }

        return answer;
    }
    static String 진법찾는놈(int base, int k) {
        int start = base;
        StringBuilder jujitsu = new StringBuilder();
        while (start > 0) {
            int realNakedChoke = start % k;
            start /= k;
            jujitsu.append(realNakedChoke);
        }
        
        // 문자열을 반전한 후 정수로 변환
        return jujitsu.reverse().toString();
    }
    
    static boolean 나는소수다(long n){
        if(n < 2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
