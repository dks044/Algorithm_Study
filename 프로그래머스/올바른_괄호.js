const OPEN_GWALHO = "(";
const CLOSE_GWALHO = ")";

function solution(s){
    var temp_arr = [];
    
    for(let i=0;i<s.length;i++){
        let target = s[i];
        if(i === 0 && target === CLOSE_GWALHO){
            return false;
        }

        if(target === OPEN_GWALHO){
            temp_arr.push(target);
            // console.log(`${i}번쨰군요! 이녀석( => '${target}' <= ) 은 넘기겠습니다!`);
            continue;
        }else {
            if(temp_arr[0] === OPEN_GWALHO){
                temp_arr.pop();
                // console.log(`${i}번쨰군요! 이녀석( => '${target}' <= ) 파괴중... `);
            }else{
                return false;
            }
        }
    }
    
    return temp_arr.length > 0 ? false : true;
}
