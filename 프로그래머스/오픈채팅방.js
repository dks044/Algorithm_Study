const E = 'Enter';
const L = 'Leave';
const C = 'Change';

function solution(record) {
    var answer = [];
    const map = new Map();
    for(let rc of record){
        const [action, uid, nickname] = rc.split(' ');
        if(action === E || action === C){
            map.set(uid,nickname);
        }
    }
    for(let rc of record){
        const [action, uid, nickname] = rc.split(' ');
        if(action === E) answer.push(`${map.get(uid)}님이 들어왔습니다.`);
        if(action === L) answer.push(`${map.get(uid)}님이 나갔습니다.`);
    }
    return answer;
}
