function solution(n, computers) {
    var answer = 0;
    const visited = new Array(n).fill(false);
    for(let i=0;i<computers.length;i++){
        if(!visited[i]){
            dfs(visited,i,computers,n);
            answer++;
        }
    }
    
    return answer;
}

const dfs = (visited,com,computers,n) => {
    visited[com] = true;
    for(let i=0;i<n;i++){
        if(computers[com][i] === 1 && !visited[i]){
            dfs(visited,i,computers,n);
        }
    }
}
