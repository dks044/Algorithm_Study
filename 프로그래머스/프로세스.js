function solution(priorities, location) {
    var answer = 0;
    const q = [];
    for(let i=0;i<priorities.length;i++) q.push(Process(i,priorities[i]));

    let useIndex = 1;
    
    while(q.length !== 0){
        const current = q.shift();
        let useFlag = true;
        if(isOverPriority(current.priority,q)){
            q.push(current);
            useFlag = false;
        }else{
            if(current.index === location){
                return useIndex;
            }
        }
        if(useFlag){
            useIndex++;
        }
    }
    
    return answer;
}


const Process = (index, priority) => {
    return {index,priority}
}

const isOverPriority = (currentPriority,q) => {
    for(const process of q){
        if(currentPriority < process.priority){
            return true;
        }
    }
    return false;
} 
