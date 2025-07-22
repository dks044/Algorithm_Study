const LEFT = [1,4,7];
const MID = [2,5,8,0];
const RIGHT = [3,6,9];

const map = new Map([['*',10],[0,11],['#',12]]); 

const mx = [1,-1,0,0];
const my = [0,0,1,-1];

function solution(numbers, hand) {
    var answer = '';
    let left = '*'; // *은 걍 10으로 친다
    let right = '#'; // *은 걍 12로 친다
    let count = 1;
    
    let graph = Array.from({length: 4 }, () =>(
        Array.from({length: 3}, () => count ++)
    ))

    for(let num of numbers){
        if(LEFT.includes(num)){
            answer += 'L'
            left = num;
        }else if(RIGHT.includes(num)){
            answer += 'R'
            right = num;
        }else{
            // *,0,# 예외 처리
            if(num === 0) num = map.get(num);
            if(map.has(left)) left = map.get(left);
            if(map.has(right)) right = map.get(right);
            //거리 계산
            const leftHand = findPostionXY(graph,left);
            const rightHand = findPostionXY(graph,right);
            const target = findPostionXY(graph,num);
            
            const leftDist = bfs(leftHand,target);
            const rightDist = bfs(rightHand,target);
            
            if(leftDist > rightDist){
                answer += 'L';
                left = num;
            }else if(rightDist > leftDist){
                answer += 'R';
                right = num;
            }else{
                if(hand === 'left'){
                    answer += 'L';
                    left = num;
                }else{
                    answer += 'R';
                    right = num;
                }
            }
        }
    }
    return answer;
}

const Position = (x,y,dist) => {
    return {x,y,dist};
}

const findPostionXY = (graph, hand) => {
    for(let i=0;i<4;i++){
        for(let j=0;j<3;j++){
            if(graph[i][j] === hand){
                return Position(i,j,0);
            }
        }
    }
}

//첫번쨰에는 손가락이, 두번쨰는 타겟(키패드)
const bfs = (startPosition, target) => {
    const q = [startPosition];
    const visited = Array(4).fill(false).map(()=>new Array(3).fill(false));
    visited[startPosition.x][startPosition.y] = true;
    while(q.length > 0){
        const current = q.shift();
        const { x, y, dist } = current;

        if (x === target.x && y === target.y) {
            return dist;
        }
        
        //상하좌우 이동하면서 탐색
        for (let i = 0; i < 4; i++) {
            const nx = x + mx[i];
            const ny = y + my[i];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 3 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                q.push(Position(nx, ny, dist + 1));
            }
        }
    }
}

