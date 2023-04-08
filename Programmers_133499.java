class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0;i<babbling.length;i++){
            babbling[i] = babbling[i].replaceAll("aya","1");
            babbling[i] = babbling[i].replaceAll("ye","2");
            babbling[i] = babbling[i].replaceAll("woo","3");
            babbling[i] = babbling[i].replaceAll("ma","4");
            char[] c = babbling[i].toCharArray();
            for(int j=0;j<c.length;j++) {
            	if(j== c.length-1) {
            		break;
            	}
            	if(Character.isDigit(c[j]) && Character.isDigit(c[j+1]) && c[j]==c[j+1]) {
            		babbling[i]="trash";
            	}
            }
        }
        
		for(int i=0;i<babbling.length;i++){
            if(babbling[i].chars().allMatch(Character::isDigit)) {
                answer += 1;
            }
		}

        
        
        
        return answer;
    }
}
