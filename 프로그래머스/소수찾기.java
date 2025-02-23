import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] visited = new boolean[7];
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        dfs(numbers,0,"");
        for(int i : set){
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    static void dfs(String numbers, int depth, String temp){
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(temp + numbers.charAt(i)));
                dfs(numbers,depth + 1, temp + numbers.charAt(i));
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
