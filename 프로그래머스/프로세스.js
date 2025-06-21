function solution(priorities, location) {
    var answer = 0;
    const q = [];
    for(let i=0;i<priorities.length;i++){
        q.push(Process(priorities[i],i));
    }
    let playCount = 1;
    while(q.length > 0){
        const process = q.shift();
        if(overProcess(process,q)){
            q.push(process);
        }else{
            if(process.index === location){
                return playCount;
            }
            playCount++;
        }
    }
    
    return answer;
}

const overProcess = (process,q) => {
    for(const p of q){
        if(p.prioritie > process.prioritie) return true;
    }
    return false;
}

const Process = (prioritie, index) => {
    return {prioritie,index};
}
