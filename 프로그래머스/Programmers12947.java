import java.util.*;
class Solution {
    int numToSum (int n){
        int sum =0;
        String temp = String.valueOf(n);
        char[] temp2 = temp.toCharArray();
        for(char c : temp2) sum += c -'0';
        return sum;
    }
    
    public boolean solution(int x) {
        boolean answer = true;
        if(x % numToSum(x) ==0) answer = true;
        else answer = false;
        
        return answer;
    }
}
