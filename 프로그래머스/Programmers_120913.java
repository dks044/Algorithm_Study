import java.util.*;
class Solution {
    public String[] solution(String my_str, int n) {
         int len = my_str.length();
	     String one = "";
         StringBuilder sb = new StringBuilder();
		 for(int i=0;i<len;i +=n) {
			 int end = Math.min(i+n, len);
			 one = my_str.substring(i, end);
             sb.append(one);
             sb.append(" ");
		 }
        String[] answer = sb.toString().split(" ");
        
        return answer;
    }
}
