//백준용
const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

// const fs = require('fs'); // fs 모듈 불러오기
// const path = require('path'); // path 모듈 불러오기

// const inputPath = path.join(__dirname, 'input.txt');
// const input = fs.readFileSync(inputPath).toString().split('\n');

function Point(x, y, dist) {
  this.x = x;
  this.y = y;
  this.dist = dist;
}

let answer = 0;
let n = parseInt(input[0].split(" ")[0]);
let m = parseInt(input[0].split(" ")[1]);
let miro = new Array(n).fill(0).map(() => new Array(m).fill(0));
let visited = new Array(n).fill(false).map(() => new Array(m).fill(false));

for (let i = 0; i < miro.length; i++) {
  for (let j = 0; j < miro[i].length; j++) {
    miro[i][j] = Number(input[i + 1][j]);
  }
}

//push, shift
let mx = [1, -1, 0, 0];
let my = [0, 0, 1, -1];

let q = [];
let start = new Point(0, 0, 1);
q.push(start);


while (q.length > 0) {
  let current = q.shift();
  if (current.x === n - 1 && current.y === m - 1) {
    answer = current.dist;
    break;
  }

  for (let i = 0; i < 4; i++) {
    let moveX = current.x + mx[i];
    let moveY = current.y + my[i];
    if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < m) {
      if (miro[moveX][moveY] === 1 && !visited[moveX][moveY]) {
        q.push(new Point(moveX, moveY, current.dist + 1));
        visited[moveX][moveY] = true;
      }
    }
  }
}

console.log(answer);
