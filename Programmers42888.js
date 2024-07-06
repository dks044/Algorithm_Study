const e = 'Enter';
const l = 'Leave';
const c = 'Change';

function solution(record) {
    var answer = [];
    var users = new Map();
    for(let i =0;i<record.length;i++){
        let r = record[i].split(' ');
        let action = r[0];
        let uid = r[1];
        let nickName = r[2];
        //입장일경우
        if(action === e){
            users.set(uid,nickName);
        }
        
        //바꿀경우
        if(action === c){
            users.set(uid,nickName);
        }
    }
    //채팅방 로직 시작
    for(let i =0;i<record.length;i++){
        let r = record[i].split(' ');
        let action = r[0];
        let nickname = users.get(r[1]);
        //입장일경우
        if(action === e){
            answer.push(nickname+'님이 들어왔습니다.');
        }
        //나갈경우
        if(action === l){
            answer.push(nickname+'님이 나갔습니다.');
        }

    }
    
    return answer;
}
