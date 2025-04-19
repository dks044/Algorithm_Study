function solution(k, dungeons) {
    var visited = new Array(dungeons.length).fill(false);
    
    return dfs(visited,k,dungeons,0, - Infinity);
}

const dfs = (visited, k, dungeons, count) => {
    let max = count;
    for(let i=0;i<dungeons.length;i++){
        let need = dungeons[i][0];
        let use = dungeons[i][1];
        if(!visited[i] && k >= need && k - use >= 0){
            visited[i] = true;
            const next = dfs(visited, k - use, dungeons, count + 1);
            max = Math.max(max,next);
            visited[i] = false;
        }
    }
    return max;
}
