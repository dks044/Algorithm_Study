function solution(cards) {
    var answer = 0;
    const visited = new Array(cards.length).fill(false);
    const groupsize = [];
    for(let i=0;i<cards.length;i++){
        let card = i;
        let size = 0;
        while(!visited[card]){
            visited[card] = true;
            card = cards[card]-1;
            size++;
        }
        groupsize.push(size);
    }
    groupsize.sort((a,b)=> b - a);
    return groupsize.length === 1 ? 0 : groupsize[0] * groupsize[1];
}
