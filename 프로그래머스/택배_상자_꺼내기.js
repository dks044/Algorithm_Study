function solution(n, w, num) {
    var answer = 0;
    var row = parseInt(boxsize(n,w) / w);
    var col = w;
    var boxs = new Array(row).fill(0).map(()=>new Array(col).fill(0));
    buildBox(boxs,row,col,n);
    var findx = 0;
    var findy = 0;
    const ssibal = find(boxs,findx,findy,row,col,num);
    findx = ssibal.x;
    findy = ssibal.y;
    return boxcounting(boxs,findx,findy,row);
}


const boxsize = (n,w) => {
    if(n % w == 0) return n;
    let a = n / w;
    let b = Math.floor(n / w);
    if(a > b){
        return w * (b + 1);
    }
}

const buildBox = (boxs,row,col,n) => {
    let boxcount = 1;
    let wayflag = true;
    for(let i=row-1;i>=0;i--){
        if(wayflag){
            for(let j=0;j<col;j++){
                if(boxcount > n){
                    boxs[i][j] = 0;
                }else{
                    boxs[i][j] = boxcount;
                }
                boxcount++;
            }
            wayflag = false;
        }else{
            for(let j=col-1;j>=0;j--){
                if(boxcount > n){
                    boxs[i][j] = 0;
                }else{
                    boxs[i][j] = boxcount;
                }
                boxcount++;
            }
            wayflag = true;
        }
    }
}

const find = (boxs,findx,findy,row,col,num) => {
    for(let i=0;i<row;i++){
        for(let j=0;j<col;j++){
            if(boxs[i][j] == num){
                return {x : i, y:j}
                break;
            }
        }
    }
}

const boxcounting = (boxs,findx,findy,row) => {
    let count = 0;
    while(findx>=0){
        if(boxs[findx][findy] === 0){
            break;
        }
        findx--;
        count++;
    }
    return count;
}
