import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int temp =0;
        for(char word : s.toCharArray()){
            if(Character.isWhitespace(word)) sb.append("");
            if(Character.isUpperCase(word)){//대문자일 경우
                word += n;
                if(word> 90){
                    temp = word -90;
                    word=64;
                    word+=temp;
                }
            }else if(Character.isLowerCase(word)){//소문자일경우
                word += n;
                if(word> 122){
                    temp = word -122;
                    word=96;
                    word+=temp;
                }
            }
            sb.append(word);
        }
        answer = sb.toString();
        
        
        return answer;
    }
}
