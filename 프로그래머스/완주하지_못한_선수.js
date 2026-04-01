

function solution(participant, completion) {
    let answer = '';
    const participantMap = makeGraph(participant);
    isMaraton(participantMap,completion);
    answer = isNotSuccessPlayer(participantMap);

    
    return answer;
}

const makeGraph = (players) => {
    const graph = new Map();
    for(let p=0;p<players.length;p++){
        const key = players[p];
        graph.set(key,[...getOfDefault(graph,key,[]),p]);
    }
    return graph;
}
    
const getOfDefault = (map,key,defaultValue) => {
    return map.get(key) ? map.get(key) : defaultValue;
}

const isMaraton = (participantMap, completion) => {
    for(let player of completion){
        const visitIndexs = participantMap.get(player);
        if(visitIndexs.length > 0) visitIndexs.pop();
        participantMap.set(player,visitIndexs);
    }
}

const isNotSuccessPlayer = (participantMap) => {
    for(let [key,value] of participantMap){
        if(value.length > 0) {
            return key;
        }
    }
    return "";
}
