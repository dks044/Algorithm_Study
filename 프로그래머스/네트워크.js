function solution(n, computers) {
    var answer = 0;
    const visited = new Array(n).fill(false);
    
    for(let i=0;i<computers.length;i++){
        if(!visited[i]){
            dfs(i,computers,visited);
            answer++;
        }
    }
    
    return answer;
}

const dfs = (index,computers,visited) => {
    visited[index] = true;
    
    for(let i=0;i<computers.length;i++){
        if(!visited[i] && computers[index][i] === 1){
            dfs(i,computers,visited);
        }
    }
}
