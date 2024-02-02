function isSame(a,b){
    let arr =[a,b];
    arr.sort();
    return arr[0];
}

function solution(survey, choices) {
    var answer = '';
    let wordPoint = new Map();
    wordPoint.set('R',0);
    wordPoint.set('T',0);
    wordPoint.set('C',0);
    wordPoint.set('F',0);
    wordPoint.set('J',0);
    wordPoint.set('M',0);
    wordPoint.set('A',0);
    wordPoint.set('N',0);
    let point =0;

    for(let i=0;i<choices.length;i++){
        if(choices[i]<4){
            point = 4 - choices[i];
            wordPoint.set(survey[i][0],wordPoint.get(survey[i][0])+point);
        }
        if(choices[i]===4) continue;
        if(choices[i]>4){
            point = choices[i] -4;
            wordPoint.set(survey[i][1],wordPoint.get(survey[i][1])+point);
        }
    }
    let attributeGraph = [['R','T'],['C','F'],['J','M'],['A','N']];
    for(let i=0;i<attributeGraph.length;i++){
        let left = wordPoint.get(attributeGraph[i][0]);
        let right = wordPoint.get(attributeGraph[i][1]);
        if(left===right){
            answer += isSame(attributeGraph[i][0],attributeGraph[i][1]);
        }
        if(left > right){
            answer += attributeGraph[i][0];
        }
        if(left < right){
            answer += attributeGraph[i][1];
        }
    }
    
    return answer;
}
