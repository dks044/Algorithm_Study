function solution(priorities, location) {
    var answer = 0;
    const arr = [];
    for(let i=0;i<priorities.length;i++){
        arr.push(new Process(priorities[i],i));
    }
    let count = 1;
    while(arr.length > 0){
        const current = arr.shift();

        if(overProcess(current,arr)){
            arr.push(current);
        }else{
            if(current.index === location){
                return count;
            }
            count++;
        }
    }
    
    return answer;
}

function Process(prioritie,index){
    this.prioritie = prioritie;
    this.index = index;
}

function overProcess(current,arr){
    for(const process of arr){
        if(current.prioritie < process.prioritie) return true;
    }
    return false;
}
