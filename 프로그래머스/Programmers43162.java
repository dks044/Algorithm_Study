class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                if(computers[i][j]==1 && !visited[j]){
                    answer++;
                    dfs(j,computers,visited);
                }
            }
        }
        
        return answer;
    }
    public void dfs(int index,int[][] computers,boolean[] visited){
        visited[index] = true;
        for(int i=0;i<computers.length;i++){
            if(computers[index][i]==1 && !visited[i]){
                dfs(i,computers,visited);
            }
        }
    }
}
