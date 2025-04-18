function solution(wallpaper) {
    let minx = Infinity;
    let maxx = -Infinity;
    let miny = Infinity;
    let maxy = -Infinity;
    
    for(let i=0;i<wallpaper.length;i++){
        for(let j=0;j<wallpaper[i].length;j++){
            if(wallpaper[i][j] === '#'){
                minx = Math.min(minx,i);
                maxx = Math.max(maxx,i);
                miny = Math.min(miny,j);
                maxy = Math.max(maxy,j);
            }
        }
    }
    
    return [minx,miny,++maxx,++maxy];
}
