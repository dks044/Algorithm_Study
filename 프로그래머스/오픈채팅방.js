var e = {
    action: 'Enter',
    text: '님이 들어왔습니다.'
};
var l = {
    action: 'Leave',
    text: '님이 나갔습니다.'
};
var c = {
    action: 'Change',
};

function solution(record) {
    var answer = [];
    let map = new Map();
    for(let sentense of record){
        const [action, uid, nickname] = sentense.split(" ");
        if(action === e.action || action === c.action) map.set(uid,nickname);
    }
    
    for(let sentense of record){
        
        const [action, uid, nickname] = sentense.split(" ");
        if(action === e.action || action === l.action){
            let word = ''
            word += map.get(uid);
            if(action === e.action) word += e.text;
            if(action === l.action) word += l.text;
            answer.push(word);
        }
    }

    
    
    return answer;
}
