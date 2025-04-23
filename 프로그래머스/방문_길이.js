function solution(dirs) {
    var answer = 0;
    let x = 0, y = 0;
    const move = {
        U: [0, 1], D: [0, -1], R: [1, 0], L: [-1, 0]
    };
    const set = new Set();
    for(let dir of dirs){
        const [dx,dy] = move[dir];
        //단, 좌표평면의 경계를 넘어가는 명령어는 무시
        if (x + dx > 5 || x + dx < -5) continue;
        if (y + dy > 5 || y + dy < -5) continue;
        
        
        //길이니까 거꾸로까지 해야 직선길이 구해짐 ㅋㅋ
        let mx = x+dx;
        let my = y+dy;
        const path = `${x},${y}->${mx},${my}`;
        const reversePath = `${mx},${my}->${x},${y}`;
        
        if(!set.has(path) && !set.has(reversePath)){
            set.add(path);
            set.add(reversePath);
            answer++;
        }
        x = mx;
        y = my;
    }
    return answer;
}

function Pointer(x,y) {
    this.x = x;
    this.y = y;
}
