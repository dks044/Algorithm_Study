function solution(players, callings) {
    var answer = [];
    var map = new Map();
    for(let i=0;i<players.length;i++){
        map.set(players[i],i);
    }
    for(let call of callings){
        let current = map.get(call);
        let next = current-1;
        
        let currentPlayer =  players[current];
        let nextPlayer = players[next];
        players[current] = players[next];
        players[next] = currentPlayer;

        map.set(call,next);
        map.set(nextPlayer,current);
    }
    return players;
}
