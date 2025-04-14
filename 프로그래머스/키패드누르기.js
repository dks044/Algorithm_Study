const Point = (x, y, dist) => {
    return { x, y, dist };
}

const PHONE = [[1,2,3],[4,5,6],[7,8,9],['*',0,'#']];
const LEFT = [1,4,7];
const MIDDLE = [2,5,8,0];
const RIGHT = [3,6,9];

const ROW = 4;
const COL = 3;

const MOVE = 4;
const movex = [1,-1,0,0];
const movey = [0,0,-1,1];


function solution(numbers, hand) {
    var answer = '';
    var left = '*';
    var right = '#';
    
    for(let num of numbers){
        if(LEFT.includes(num)){
            left = num;
            answer += 'L';
        }
        if(RIGHT.includes(num)){
            right = num;
            answer += 'R';
        }
        if(MIDDLE.includes(num)){
            let left_dist = bfs(left,num);
            let right_dist = bfs(right,num);
            if(left_dist < right_dist){
                answer += 'L';
                left = num;
            }
            if(left_dist > right_dist){
                answer += 'R';
                right = num;
            }
            if(left_dist == right_dist){
                if(hand === 'right'){
                    answer += 'R';
                    right = num;
                }
                if(hand === 'left'){
                    answer += 'L';
                    left = num;
                }
            }
        }
    }
    
    return answer;
}
function getPosition(current){
    for(let i=0;i<PHONE.length;i++){
        for(let j=0;j<PHONE[i].length;j++){
            if(PHONE[i][j] == current){
                return Point(i,j,0);
            }
        }
    }
}


function bfs(current,target){
    let start = getPosition(current);
    let q = [start];
    let visited = new Array(ROW).fill(false).map(()=>new Array(COL).fill(false));
    while(q.length != 0){
        let current = q.shift();
        if(PHONE[current.x][current.y] == target){
            return current.dist;
        }
        //상하좌우 ㄱㄱ
        for(let i=0;i<MOVE;i++){
            let x = current.x + movex[i];
            let y = current.y + movey[i];
            let dist = current.dist;
            if(x >= 0 && x < ROW && y >= 0 && y < COL){
                if(!visited[x][y]){
                    q.push(Point(x,y,dist + 1));
                }
            }
        }
    }
}
