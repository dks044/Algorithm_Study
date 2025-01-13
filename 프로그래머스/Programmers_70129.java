import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(s.length() !=1){
            char[] ch = s.toCharArray();
            ArrayList<Character> ch_arr = new ArrayList<>();
            for(int i=0;i<ch.length;i++){
                ch_arr.add(ch[i]);
            }

            for(int i=0;i<ch_arr.size();i++){
                if(ch_arr.get(i) == '0'){
                    ch_arr.remove(i);
                    answer[1] +=1;
                    i--; //i--를 해줌으로써 완벽하게 요소를 삭제하게 한다.
                }
            }
            s = Integer.toBinaryString(ch_arr.size());//ex)110
            System.out.println(s);//0뺴고 남은 문자열길이 이진수
            answer[0] +=1;   
        }
        
        
        
        return answer;
    }
}
