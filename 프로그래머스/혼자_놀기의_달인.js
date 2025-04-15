function solution(cards) {
    var answer = 0;
    var visited = Array(cards.length).fill(false);
    
    var groupsize = [];
    for(let i=0;i<cards.length;i++){
        let idx = i;
        let count =0;
        while(!visited[idx]){
            visited[idx] = true;
            idx = cards[idx] -1;
            count++;
        }
        groupsize.push(count);
    }
    if(groupsize.length == 1) return 0;
    groupsize.sort((a,b)=> b-a);
    
    return groupsize[0] * groupsize[1]; 
}
