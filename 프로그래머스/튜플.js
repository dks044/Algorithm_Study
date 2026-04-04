// 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플
const OPEN_BRACE = '{';
const CLOSE_BRACE = '}';

function solution(s) {
    var answer = [];
    s = parseArrayToArr(s);
    s.sort((a,b)=> a.length - b.length);

    const set = new Set([...s]);
    answer.push(Number(s[0]));
    //case1 [ '2', '2,1', '2,1,3', '2,1,3,4' 
    //case2 [ '2', '2,1', '1,2,3', '1,2,4,3' ]
    //case3 [ '111', '20,111' ]
    for(let i=1; i< s.length ; i++){
        let word = s[i].split(",");
        for(let w of word){
            if(answer[i-1] !== w && !set.has(w)){
                answer.push(Number(w));
                set.add(w);
            }
        }
    }
    
    return answer;
}

const parseArrayToArr = (word) => {
    let parseArr = [];
    let arr = [...word];
    arr.shift();
    arr.pop();
    arr = arr.join('');
    
    
    let tempArr = [];
    let trigger = false;
    for(let t of arr){
        if(t === OPEN_BRACE) trigger = true;
        if(t === CLOSE_BRACE){
            tempArr = tempArr.join('');
            parseArr.push(tempArr);
            tempArr = [];
            trigger = false;
        }
        if(trigger && (t !== OPEN_BRACE && t !== CLOSE_BRACE)){
            tempArr.push(t);
        }
    }
    return parseArr;
}


