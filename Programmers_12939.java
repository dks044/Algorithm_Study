import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split(" ");
        ArrayList<Integer> int_arr = new ArrayList<>();
        for(int i=0;i<temp.length;i++){
            int_arr.add(Integer.parseInt(temp[i]));
        }
        int max = Integer.MIN_VALUE; // 최소값을 Integer.MIN_VALUE로 초기화
        int min = Integer.MAX_VALUE; // 최대값을 Integer.MAX_VALUE로 초기화

        for (int i = 0; i < int_arr.size(); i++) {
            int num = int_arr.get(i);
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        
        answer = sb.toString();
        return answer;
    }
}
