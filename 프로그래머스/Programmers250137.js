
function solution(bandage, health, attacks) {
    let originHealth = health;
    let bonusTime = bandage[0];
    let healing = bandage[1];
    let bonusHealing = bandage[2];
    
    var answer = 0;
    let attackMap = new Map();
    let maxTime = 0;
    for(let i=0;i<attacks.length;i++){
        let key = attacks[i][0];
        let value = attacks[i][1];
        if(maxTime < key) maxTime = key;
        attackMap.set(key,value);
    }
    let continuityBandage = 0;
    for(let i=1;i<=maxTime;i++){
        continuityBandage++;
        if(attackMap.has(i)){
            continuityBandage = 0;
            health -= attackMap.get(i);
            if(health <=0) return -1;
            continue;
        }
        if(health < originHealth){
            health += healing;
            if(continuityBandage == bonusTime){
                health += bonusHealing;
                continuityBandage = 0;
            }
        }
        if(health >= originHealth) health = originHealth;
    }
    answer = health;
    return answer;
}
