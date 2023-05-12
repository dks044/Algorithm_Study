import java.util.*;
class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
         for(int n=i;n<=j;n++){
            String a = String.valueOf(n);
            for(char word : a.toCharArray()){
                if(word-'0' == k){
                    answer ++;
                    continue;
                }
            }
        }
        
        
        return answer;
    }
}
