function solution(maps) {
    var rowLength = maps.length;
    var colLength = maps[0].length;
    const chMap = Array.from(Array(rowLength), 
                       () => Array(colLength).fill(null));
    //방문 체크
    const visited = Array.from(Array(rowLength), 
                       () => Array(colLength).fill(false));
    
    for(let i = 0; i < rowLength; i++){
        for(let j = 0; j < colLength; j++){
            chMap[i][j] = maps[i][j];
        }
    }

    //동서남북
    const nx = [1, -1, 0, 0];
    const ny = [0, 0, 1, -1];
    const days = [];
    
    for(let i = 0; i < rowLength; i++){
        for(let j = 0; j < colLength; j++){
            if(!isNaN(chMap[i][j]) && !visited[i][j]){
                const q = [{x : i, y : j}];
                let sum = 0;
                while(q.length > 0){
                    const {x, y} = q.shift();
                    if(visited[x][y]) continue;
                    visited[x][y] = true;
                    
                    const currentDay = parseInt(chMap[x][y],10);
                    sum += currentDay;
                    for(let move =0;move<4;move++){
                        const mx = x + nx[move];
                        const my = y + ny[move];
                        if(mx >= 0 && mx < maps.length && 
                           my >= 0 && my < maps[0].length
                          ){
                            if(!isNaN(chMap[mx][my]) && !visited[mx][my]){
                                q.push({ x : mx, y : my});
                                //visited[mx][my] = true;
                            }
                        }
                    }
                }
                days.push(sum);
            }
        }
    }
    if(days.length === 0) return [-1];
    
    days.sort((a, b) => a - b);
    return days;
}

