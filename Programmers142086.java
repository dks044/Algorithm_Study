import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        char[] word = s.toCharArray();
        int count =0;
        for(int i=0;i<word.length;i++){
            if(!sb.toString().contains(Character.toString(word[i]))){
                sb.append(word[i]);
                answer[i]= -1;
                continue;
            }else{
                sb.append(word[i]);
                for(int j=sb.toString().length()-1;j>=0;j--){
                    if(sb.toString().charAt(j)==word[i] && j!=sb.toString().length()-1){
                        answer[i] = count;
                        count =0;
                        break;
                    }
                    count +=1;
                }
            }
        }
        
        return answer;
    }
}
