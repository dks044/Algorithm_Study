function solution(cards) {
    var answer = 0;
    var visited = new Array(cards.length).fill(false);
    var groupsize = [];
    
    for(let i=0;i<cards.length;i++){
        let cardindex = i;
        let count = 0;
 
        while(!visited[cardindex]){
            visited[cardindex]=true;
            cardindex = cards[cardindex]-1;
            count++;
        }
        if(count > 0) groupsize.push(count);
    }
    
    groupsize.sort((a,b)=> b - a);
    
    
    return groupsize.length === 1 ? 0 : groupsize[0] * groupsize[1];
}
