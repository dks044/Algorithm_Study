import java.util.*;
class Solution {
    public int[] solution(String s) {
       s = s.substring(2, s.length());
       s= s.substring(0, s.length()-2);
       String[] ss = s.split("\\},\\{");
       
       Arrays.sort(ss, (s1,s2) -> Integer.compare(s1.length(), s2.length()));
       
       ArrayList<Integer> num = new ArrayList<>();
       for(String str : ss) {
    	   for(String stt :str.split(",")) {
    		   if(!num.contains(Integer.valueOf(stt))) num.add(Integer.valueOf(stt));
    	   }
       }
       int[] answer = new int[num.size()];
       for(int i=0;i<num.size();i++) answer[i] = num.get(i);
        
        return answer;
    }
}
