import java.util.*;
class Solution {
    //Optional
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        //틀
        visited = new boolean[numbers.length()];
        
        dfs(0,numbers,"");

        for(int i : set){
            System.out.println(i);
            if(isSoju(i)) answer++;
        }
        
        return answer;
    }
    static void dfs(int depth,String numbers, String temp){
        if(depth > numbers.length()){
            return;
        }
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(temp + numbers.charAt(i)));
                dfs(depth + 1,numbers,temp + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    //소수인지 구하는새끼
    static boolean isSoju(int number){
        if(number < 2) return false;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i ==0) return false;
        }
        return true;
    }
}
