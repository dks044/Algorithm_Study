import java.util.*;
class Solution {
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited = new boolean[7];
    public int solution(String numbers) {
        dfs(numbers,"");
        for(int i : set){
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    static void dfs(String numbers, String temp){
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(temp + numbers.charAt(i)));
                dfs(numbers, temp + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    static boolean isPrime(int number){
        if(number < 2) return false;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i ==0) return false;
        }
        return true;
    }
}
