import java.util.*;
class Solution {
    public int solution(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        char[] word = s.toCharArray();
        StringBuilder sb = new StringBuilder(); //비교용
        StringBuilder sb2 = new StringBuilder(); //정답제출용
        int number = 0;
        for(int i=0;i<word.length;i++){
            //숫자일경우
            if(Character.isDigit(word[i])){
                sb2.append(word[i]);
            }else{
                sb.append(word[i]);
                if(map.containsKey(sb.toString())){
                    number = map.get(sb.toString());
                    sb2.append(number);
                    sb.setLength(0);
                }
            }
        }
        String num = sb2.toString();
        return Integer.parseInt(num);
    }
}
