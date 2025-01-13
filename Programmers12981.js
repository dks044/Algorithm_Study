function solution(n, words) {
    var answer = [0,0];
    var set = new Set();
    set.add(words[0]);
    
    var number = 1;
    for(let word=1; word < words.length; word++){
        let preventWord = words[word-1];
        let preventLastWord = preventWord[preventWord.length-1];
        let currentWord = words[word];
        if(!set.has(currentWord)) set.add(currentWord);
        else{
            answer [0] = word % n +1;
            answer [1] = Math.floor( (word / n) +1);
            break;
        }
        let currentWordFirstWord = currentWord[0];
        
        if(preventLastWord !== currentWordFirstWord){
            answer [0] = word % n +1;
            answer [1] = Math.floor( (word / n) +1);
            break;
        }
    }
    

    return answer;
}
