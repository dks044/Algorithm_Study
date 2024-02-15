class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int index, int[][] computers, boolean[] visited) {
        visited[index] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}
