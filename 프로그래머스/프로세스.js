function solution(priorities, location) {
    var answer = 0;
    processes = makeProcesses(priorities);
    
    let startCount = 1;
    while(processes.length > 0){
        const currentProcess = processes.shift();
        if(isHigherThanPriority(currentProcess,processes)){
            processes.push(currentProcess);
        }else{
            if(location === currentProcess.index){
                answer = startCount;
                break;
            }
            startCount++;
        }
    }
    
    return answer;
}

function Process(index,priority){
    this.index = index;
    this.priority = priority;
}

const makeProcesses = (priorities) => {
    const processes = [];
    for(let p=0;p<priorities.length;p++){
        processes.push(new Process(p,priorities[p]));
    }
    return processes;
}

const isHigherThanPriority = (process, processes) => {
    for(let p of processes){
        if(p.priority > process.priority) return true;
    }
    return false;
}
