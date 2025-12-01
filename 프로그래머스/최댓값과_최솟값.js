function solution(s) {
    const arr = s.split(" ").map((value)=> Number(value)).sort((a,b)=> a-b);
    
    return `${arr[0]} ${arr[arr.length-1]}`;
}
