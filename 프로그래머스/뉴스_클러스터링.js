function solution(str1, str2) {
    const a = arr(str1);
    const b = arr(str2);
    const { intersection, union } = getMultisetSize(a, b);

    if (union === 0) return 65536;
    return Math.floor((intersection / union) * 65536);
}


const arr = (str) => {
    const array = [];
    
    for(let i=0;i<str.length-1;i++){
        let element = ''
        let check = 0;
        while(check < 2){
            if(charReg(str[i+check])){
                element += str[i+check];            
            }
            check++;
        }
        if(element.length === 2) array.push(element.toLowerCase());
    }
    return array;
}

const getMultisetSize = (a, b) => {
    const aMap = new Map();
    const bMap = new Map();

    a.forEach(v => aMap.set(v, (aMap.get(v) || 0) + 1));
    b.forEach(v => bMap.set(v, (bMap.get(v) || 0) + 1));

    let intersection = 0;
    let union = 0;

    const allKeys = new Set([...aMap.keys(), ...bMap.keys()]);
    allKeys.forEach(key => {
        const aCount = aMap.get(key) || 0;
        const bCount = bMap.get(key) || 0;
        intersection += Math.min(aCount, bCount);
        union += Math.max(aCount, bCount);
    });

    return { intersection, union };
};


const charReg = (char) => /^[a-zA-Z]$/.test(char);
