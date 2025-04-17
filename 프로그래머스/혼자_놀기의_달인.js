function solution(cards) {
    var visited = Array(cards.length).fill(false);
    var groupsize = [];
    for(let i=0;i<cards.length;i++){
        let index = i;
        let count = 0;
        while(!visited[index]){
            visited[index] = true;
            index = cards[index] -1;
            count++;
        }
        groupsize.push(count);
    }
    groupsize.sort((a,b)=>b - a);
    if(groupsize.length ==0) return 0;
    return groupsize[0] * groupsize[1];
}
