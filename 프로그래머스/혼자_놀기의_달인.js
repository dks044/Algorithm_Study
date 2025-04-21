function solution(cards) {
    var groupsize = [];
    var visited = new Array(cards.length).fill(false);
    
    for(let i=0;i<cards.length;i++){
        let size =0;
        let cardindex = i;
        let count =0;
        while(!visited[cardindex]){
            visited[cardindex] = true;
            cardindex = cards[cardindex]-1;
            count++;
        }
        groupsize.push(count);
        
    }
    groupsize.sort((a,b)=> b-a);
    
    return groupsize.length === 0 ? 0 : groupsize[0] * groupsize[1];
}
