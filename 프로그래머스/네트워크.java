class Solution {
    static int answer = 0;

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                if(computers[i][j]==1 && !visited[j]){
                    answer++;
                    dfs(computers,j,visited);
                }
            }
        }
            
        return answer;
    }
    static void dfs(int[][] computers,int current,boolean[] visited){
        visited[current] = true;
        for(int i=0;i<computers.length;i++){
            if(computers[current][i] == 1 && !visited[i]){
                dfs(computers,i,visited);
            }
        }        

    }
}
