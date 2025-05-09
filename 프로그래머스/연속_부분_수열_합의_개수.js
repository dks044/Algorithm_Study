function solution(elements) {
    var answer = 0;
    const length = elements.length;
    const combined = [...elements,...elements];

    
    const set = new Set();
    let count = 1;
    while(count <= length){
        for(let i=0;i<combined.length-count;i++){
            let sum = 0;
            for(let j=i;j<i+count;j++){
                sum += combined[j];
            }
            set.add(sum);
        }
        count++;
    }


    return set.size;
}
