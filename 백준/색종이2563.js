const fs = require('fs');

const filePath = process.platform === 'linux' ? '/dev/stdin' : 'input.txt';

const input = fs.readFileSync(filePath).toString().trim().split('\n'); 

const PAPER_SIZE = 100;
const COLOR_PAPER_SIZE = 10;

const DEFAULT_BLANK = 0;
const CONTAIN_BLANK = 1;
const DISTINCT_BLANK = 2;

//flag
//색종이가 도화지 밖으로 나가는 경우는 없다

const N = Number(input[0]);

function solution() {
    const graph = Array(PAPER_SIZE).fill(DEFAULT_BLANK).map(()=> new Array(PAPER_SIZE).fill(DEFAULT_BLANK));

    for(let i=1;i<input.length;i++){
        let [x, y] = input[i].split(" ");
        x--;
        y--;
        // xp = x point | yp = y point
        for(let xp=x; xp < x+COLOR_PAPER_SIZE; xp++){
            for(let yp=y; yp < y+COLOR_PAPER_SIZE; yp++){
                graph[xp][yp] = graph[xp][yp] == DEFAULT_BLANK ? CONTAIN_BLANK : DISTINCT_BLANK;
            }
        }
    }

    // 1)) 첫번쨰 삽질
    // let minX = Number.MAX_VALUE;
    // let maxX = 0;
    // let minY = Number.MAX_VALUE;
    // let maxY = 0;

    // for(let i=0;i<PAPER_SIZE;i++){
    //     for(let j=0;j<PAPER_SIZE;j++){
    //         if(graph[i][j] === DISTINCT_BLANK){
    //             minX = Math.min(minX,i);
    //             maxX = Math.max(maxX,i);
    //             minY = Math.min(minY,j);
    //             maxY = Math.max(maxY,j);
    //         }
    //     }
    // }

    // let distinctExtent = (maxX - minX+1) * (maxY - minY+1);
    // const answer = (COLOR_PAPER_SIZE * COLOR_PAPER_SIZE * N) - distinctExtent;
    // console.log(answer);

    let ssibal = 0;
    for(let i=0;i<PAPER_SIZE;i++){
        for(let j=0;j<PAPER_SIZE;j++){
            if(graph[i][j] > DEFAULT_BLANK){
                ssibal++;
            }
        }
    }
    console.log(ssibal);
}

solution();
