function solution(priorities, location) {
    const q = [];
    priorities.forEach((v,i)=> q.push(new Process(i,v)));
    
    let use =1;
    while(q.length !== 0){
        const current = q.shift();
        if(isOverProiority(current,q)){
            q.push(current);
        }else{
            if(current.index === location){
                return use;
            }
            use++;
        }
    }
    return use;
}

function Process(index,proiortie){
    this.index = index;
    this.proiortie = proiortie;
}

const isOverProiority = (current, q) =>{
    for(const process of q){
        if(current.proiortie < process.proiortie) return true;
    }
    return false;
}
