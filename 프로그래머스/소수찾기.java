import java.util.*;
class Solution {
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers,"",visited);
        for(int i : set){
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    static void dfs(String numbers, String temp, boolean[] visited){
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(temp + numbers.charAt(i)));
                dfs(numbers, temp + numbers.charAt(i),visited);
                visited[i] = false;
            }
        }
    }
    static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
