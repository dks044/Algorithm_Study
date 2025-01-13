class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int count=0;
        int index_a=0;
        int index_b=0;
        while(count < goal.length){
            if(index_a<cards1.length && goal[count].equals(cards1[index_a]) && index_a<cards1.length){
                index_a+=1;
                count++;
                continue;
            }else if(index_b<cards2.length && goal[count].equals(cards2[index_b])){
                index_b+=1;
                count++;
                continue;
            }else return "No";
        }
        
        
        
        
        
        return "Yes";
    }
}
