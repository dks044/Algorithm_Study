class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin,target,words,0);
        return answer;
    }
    static void dfs(String begin, String target, String[] words,int count){
        if(begin.equals(target)){
            answer = count;
            return;
        }
        for(int i=0;i<words.length;i++){
            int ct = 0;
            for(int j=0;j<words[i].length();j++){
                if(begin.charAt(j) == words[i].charAt(j)) ct++;
                
                if(ct == words[i].length() - 1 && !visited[i]){
                    visited[i] = true;
                    dfs(words[i],target,words,count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
