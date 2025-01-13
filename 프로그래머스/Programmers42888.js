const e = 'Enter';
const l = 'Leave';
const c = 'Change';

function solution(record) {
    var answer = [];
    var map = new Map();
    for(let sentence of record){
        let [action,uid,nickname] = sentence.split(" ");
        if(action === e || action === c) map.set(uid,nickname);
    }
    for(let sentence of record){
        let [action,uid,nickname] = sentence.split(" ");
        if(action === e) answer.push(map.get(uid)+'님이 들어왔습니다.');
        if(action === l) answer.push(map.get(uid)+'님이 나갔습니다.');
    }
    
    return answer;
}
