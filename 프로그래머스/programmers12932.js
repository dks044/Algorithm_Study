function solution(n) {
    return ssibal(String(n));
}

const ssibal = (n) => {
    const arr = n.split('').reverse().map((v)=>Number(v));
    return arr;
}
