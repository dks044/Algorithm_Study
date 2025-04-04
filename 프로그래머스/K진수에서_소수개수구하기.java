import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String numWord = K진수구하기(n,k,"");
        for(String w : numWord.split("0")){
            if(!w.isEmpty() && 소수구하기(Long.parseLong(w))) answer++;
        }
        return answer;
    }

    static String K진수구하기(int n, int k,String temp){
        if(n == 0) {
            return temp;
        }
        return K진수구하기(n / k, k, (n % k) + temp);
    }
    static String 문자열뒤집기(String word){
        StringBuilder sb = new StringBuilder();
        for(int i=word.length()-1;i >= 0;i--){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
    static boolean 소수구하기(long num){
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i=3; i<=Math.sqrt(num); i+=2){
            if(num % i == 0) return false;
        }
        return true;
    }
}
