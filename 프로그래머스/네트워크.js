function solution(n, computers) {
    var answer = 0;
    const visited = new Array(n).fill(false);
    for(let i=0;i<computers.length;i++){
        if(!visited[i]){
            dfs(visited,i,computers);
            answer++;
        }
    }
        
    return answer;
}

const dfs = (visited,start,computers) => {
    visited[start] = true;
    
    for(let i=0;i<computers.length;i++){
        if(!visited[i] && computers[start][i] === 1){
            dfs(visited,i, computers);
        }
    }
}
