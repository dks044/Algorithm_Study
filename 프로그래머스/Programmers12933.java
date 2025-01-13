import java.util.*;
class Solution {
    public ArrayList<Integer> createArr(long n){
        String temp = String.valueOf(n);
        char[] ch_temp_arr = temp.toCharArray();
        ArrayList<Integer> int_arr = new ArrayList<>();
        for(char c : ch_temp_arr) int_arr.add(c - '0');
        return int_arr;
    }
    
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> int_arr = createArr(n);
        Collections.sort(int_arr);
        Collections.reverse(int_arr);
        for(int i : int_arr) sb.append(i);
        long answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}
