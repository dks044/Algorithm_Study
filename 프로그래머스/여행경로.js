let answer = [];
function solution(tickets) {

    tickets.sort((a, b) => a[1].localeCompare(b[1]));
    
    const visited = Array(tickets.length).fill(false);
    dfs(['ICN'],visited,tickets,0);
    
    return answer;
}

const dfs = (str,visited,tickets,depth) => {
    if(depth === tickets.length){
        answer = [...str];
        return true;
    }else{
        for(let i=0;i<tickets.length;i++){
            if(!visited[i] && str[str.length-1] === tickets[i][0]){
                visited[i] = true;
                str.push(tickets[i][1]);
                if(dfs(str, visited, tickets, depth + 1)) return true;
                
                str.pop();
                visited[i] = false;
            }
        }   
    }
}
