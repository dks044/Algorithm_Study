function solution(progresses, speeds) {
    var answer = [];
    //var day =0;
    var check = 0;
    while(!isDoneProgress(progresses)){
        progresses = progresses.map((progres,index) => progres + speeds[index]);
        //day++;
        
        let count =0;
        while(progresses[check] >= 100){
            if(progresses[check] >= 100){
                check++;
                count++;    
            }
        }
        if(count > 0) answer.push(count);
        //console.log(day,'일차 => ',progresses);
    }
    
    return answer;
}

const isDoneProgress = (progresses) => {
    for(let p of progresses){
        if(p < 100) return false;
    }
    return true;
}
