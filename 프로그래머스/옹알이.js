let a = 'aya';
let b = 'ye';
let c = 'woo';
let d = 'ma' ;

function solution(babbling) {
    var answer = 0;
    babbling = babbling.map((v)=> {
        v = v.replaceAll(a,1);
        v = v.replaceAll(b,2);
        v = v.replaceAll(c,3);
        v = v.replaceAll(d,4);
        return v;
    })
    for(let i=0;i<babbling.length;i++){
        let valid = true;
        console.log(babbling[i]);
        for(let j=0;j<babbling[i].length;j++){
            let current = babbling[i][j];
            let next = '';
            if(j < babbling[i].length -1) next = babbling[i][j+1];
            if(isNaN(current)){
                valid = false;
                break;
            }else{
                if(current === next){
                    valid = false;
                    break;
                }
            }
        }
        if(valid) answer++;
    }
    
    return answer;
}
