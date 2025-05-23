'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the 'climbingLeaderboard' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY ranked
 *  2. INTEGER_ARRAY player
 */

function climbingLeaderboard(ranked, player) {
    let answer = [];
    const sortedRanked = [...new Set(ranked)].sort((a,b)=> b - a);
    for(let p of player){
        let left = 0;
        let right = sortedRanked.length-1;
        let mid = 0;
        while(left <= right){
            mid = Math.floor( (left + right) / 2);
            
            if(sortedRanked[mid] > p){
                left = mid  +1;
            }
            if(sortedRanked[mid] <= p){
                right = mid -1;
            }
        }
        if(sortedRanked[mid] > p){
            answer.push(mid+2);
        }else answer.push(mid+1);
    }
    
    return answer;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const rankedCount = parseInt(readLine().trim(), 10);

    const ranked = readLine().replace(/\s+$/g, '').split(' ').map(rankedTemp => parseInt(rankedTemp, 10));

    const playerCount = parseInt(readLine().trim(), 10);

    const player = readLine().replace(/\s+$/g, '').split(' ').map(playerTemp => parseInt(playerTemp, 10));

    const result = climbingLeaderboard(ranked, player);

    ws.write(result.join('\n') + '\n');

    ws.end();
}
