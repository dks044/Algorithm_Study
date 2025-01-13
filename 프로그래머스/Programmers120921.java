import java.util.*;
class Solution {
    public int solution(String A, String B) {
        int answer =0;
        if(A.equals(B)){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
		char[] wd = A.toCharArray();
		while(!sb.toString().equals(B)) {
			if(answer == B.length()) {
				answer = -1;
				break;
			}
			char last = wd[wd.length-1];
			for(int i=wd.length-1; i>0 ;i--) {
				wd[i] = wd[i-1];
			}
			wd[0]=last;
			answer +=1;
			for(char word : wd) {
				sb.append(word);
			}
			if(sb.toString().equals(B)) {
				break;
			}else{
                sb.setLength(0);
            }
		}
        
        return answer;
    }
}
