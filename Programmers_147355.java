import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        char[] num = t.toCharArray();
        int p_length = p.length();
        int index=0;
        while(p_length+index<=t.length()){
            sb.append(t.substring(0+index,p_length+index));
            if(Long.parseLong(sb.toString()) <= Long.parseLong(p)){
                answer +=1;
            }
            index++;
            sb.setLength(0);
        }
    
        
        return answer;
    }
}
