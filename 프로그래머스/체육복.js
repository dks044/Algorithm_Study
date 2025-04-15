function solution(n, lost, reserve) {
    var answer = 0;
    var room = new Array(n).fill(1);
    for(let i of reserve) room[i-1] = 2;
    for(let i of lost) room[i-1] -= 1;
    
    for(let i=1; i<n; i++){
        if(room[i-1] == 0 && room[i] > 1){
            room[i-1] = 1;
            room[i] = 1;
        }
        if(room[i] == 0 && room[i-1] > 1){
            room[i-1] = 1;
            room[i] = 1;
        }
    }
    for(let i of room){
        if(i > 0) answer++;
    }
    
    return answer;
}
