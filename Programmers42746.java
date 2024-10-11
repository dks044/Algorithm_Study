import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] wordNums = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            wordNums[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(wordNums ,(a1,a2) -> (a2+a1).compareTo(a1+a2));
        StringBuilder answer = new StringBuilder();
        for(String s : wordNums) answer.append(s);
        
        if(answer.toString().charAt(0) == '0') return "0";
        
        return answer.toString();
    }
}
