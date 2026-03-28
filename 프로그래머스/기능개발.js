const DONE_PERCENT = 100;

function solution(progresses, speeds) {
    let index = 0;
    var answer = [];
    
    while(!isWorkDone(progresses)){
        progresses = progresses.map((v, i) => v + speeds[i]);
        let doneCount = 0;
        while(progresses[index] >= DONE_PERCENT){
            doneCount++;
            index++;
        }
        if(doneCount > 0) answer.push(doneCount);
    }
    
    return answer;
}

const isWorkDone = (progresses) => {
    for(let progress of progresses){
        if(progress < DONE_PERCENT) return false;
    }
    return true;
}
