function solution(n) {
    let ans = 0;
    

    if (n % 2 !== 0) {
        ans++;
        n--; 
    }


    while (n > 0) {
        n /= 2; 
        if (n % 2 !== 0) {
            ans++; 
            n--; 
        }
    }
    
    return ans;
}
