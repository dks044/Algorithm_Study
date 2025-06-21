function solution(progresses, speeds) {
    var answer = [];
    let progressesIndex = 0;
    while(!isDoneProgress(progresses)){
        progresses = progresses.map((value,index)=> value + speeds[index]);
        let count = 0;
        while(progresses[progressesIndex] >= 100){
            count++;
            progressesIndex++;
        }
        if(count > 0) answer.push(count);
    }
    return answer;
}

const isDoneProgress = (progresses) => {
    for(let p of progresses){
        if(p < 100) return false;
    }
    return true;
}
