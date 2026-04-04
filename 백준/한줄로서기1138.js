const fs = require('fs');

const filePath = process.platform === 'linux' ? '/dev/stdin' : 'input.txt';

const input = fs.readFileSync(filePath).toString().trim().split('\n');

function solution() {
    const N = Number(input[0]); 
    // arr: [2, 1, 1, 0] (각 사람 앞에 있는 더 큰 사람의 수)
    const arr = input[1].split(" ").map(Number); 
    
    const result = [];

    for (let i = N; i >= 1; i--) {
        const tallerCount = arr[i - 1]; 
        
        result.splice(tallerCount, 0, i); 
    }

    console.log(result.join(' ')); 
}

solution();
