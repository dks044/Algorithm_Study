const e = 'Enter';
const l = 'Leave';
const c = 'Change';

function solution(record) {
    var answer = [];
    const maps = new Map();
    for(let r of record){
        let [action, uid, nickname] = r.split(" ");
        if(action === e || action === c){
            maps.set(uid,nickname);
        }
    }
    for(let r of record){
        let [action, uid, nickname] = r.split(" ");
        if(action === e){
            answer.push(maps.get(uid)+'님이 들어왔습니다.');
        }
        if(action === l){
            answer.push(maps.get(uid)+'님이 나갔습니다.');
        }
    }
    
    return answer;
}
