/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, color) {
    const visited = new Array(image.length).fill(false).map(()=> Array(image[0].length).fill(false));
    visited[sr][sc] = true;
    dfs(sr,sc,visited,image);
    for(let i=0;i<image.length;i++){
        for(let j=0;j<image[i].length;j++){
            if(visited[i][j]) image[i][j] = color;
        }
    }
    return image;
};

const dfs = (x,y,visited,image) => {
    const mx = [1,-1,0,0];
    const my = [0,0,1,-1];
    
    for(let i=0;i<4;i++){
        let movex = x + mx[i];
        let movey = y + my[i];

        if(isValidLength(movex,movey,image) && !visited[movex][movey] && isSameFill(x,y,movex,movey,image) ){
            visited[movex][movey] = true;
            dfs(movex,movey,visited,image);
        }
    }
}

const isSameFill = (x,y,movex,movey,image) => {
    if(image[x][y] === image[movex][movey]){
        return true;
    }
    return false;
}

const isValidLength = (x,y,image) => {
    if(x >= 0 && x < image.length && y >= 0 && y < image[0].length){
        return true;
    }
    return false;
}
