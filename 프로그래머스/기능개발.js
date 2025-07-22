function solution(progresses, speeds) {
    var answer = [];
    
    let index = 0;
    while(!over(progresses)){
        progresses = progresses.map((value, index) => value + speeds[index]);
        
        let count = 0;
        while(progresses[index] >= 100){
            count++;
            index++;
        }
        if(count > 0) answer.push(count);
    }
    
    return answer;
}

const over = (progresses) => {
    for(const progress of progresses){
        if(progress < 100) return false;
    }
    return true;
}
