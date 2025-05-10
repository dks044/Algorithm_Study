function solution(tickets) {
    var answer = [];
    tickets.sort((a, b) =>
      a[0] === b[0]
        ? a[1].localeCompare(b[1])
        : a[0].localeCompare(b[0])
    );
    const visited = new Array(tickets.length).fill(false);
    const realPath = dfs(['ICN'],visited,tickets);
    
    
    return realPath;
}

const dfs = (path,visited,tickets) => {
    if(path.length === tickets.length+1){
         return [...path];
    }
    
    for(let i=0;i<tickets.length;i++){
        const start = path[path.length-1];
        const ticketsStart = tickets[i][0];
        const ticketsEnd = tickets[i][1];
        if(!visited[i] && start === ticketsStart){
            visited[i] = true;
            path.push(ticketsEnd);
            const result = dfs(path,visited,tickets);
            if(result) return result;
            visited[i] = false;
            path.pop();
        }
    }
}
