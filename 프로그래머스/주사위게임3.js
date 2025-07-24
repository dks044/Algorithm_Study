function solution(a, b, c, d) {
    var answer = 0;
    const map = new Map();
    map.set(a, (map.get(a) || 0) +1);
    map.set(b, (map.get(b) || 0) +1);
    map.set(c, (map.get(c) || 0) +1);
    map.set(d, (map.get(d) || 0) +1);
    
    const sortedMap = ([...map.entries()].sort((a,b) => b[1] - a[1]));
    
    const [fkey, fvalue] = sortedMap[0];
    
    
    if(fvalue === 4) return fkey * 1111;
    
    if(fvalue === 3){
        const [skey, svalue] =  sortedMap[1];
        return (10 * fkey + skey) * (10 * fkey + skey); 
    }
    if(fvalue === 2){
        const [skey, svalue] =  sortedMap[1];
        //주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면
        if(svalue === 2 && skey !== fkey){
            return (fkey + skey) * Math.abs(fkey - skey);
        }else{
            const [tkey, tvalue] =  sortedMap[2];
            return skey * tkey;
        }
    }
    if(fvalue === 1){
        const keys = sortedMap.map((v) => v[0]).sort((a,b)=> a- b);
        return keys[0];
    }
    
    
    return answer;
}
