class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] wall = new boolean[n];
        for(int i=0;i<wall.length;i++) wall[i] = true;
        for(int i : section) wall[i-1] = false;
        //for(boolean b : wall) System.out.println(b);
        
        if(m==1){
            for(int i=0;i<wall.length;i++){
                if(wall[i]==false){
                    wall[i]=true;
                    answer++;
                }
            }
        }else{
            for(int i=wall.length-1;i>=0;i--){
                if(wall[i]==false){
                    for(int j=i;j>=i-m+1&& j>=0;j--){
                        wall[j] = true;
                    }
                    answer++;
                }
            }
        }
        
        
        
        return answer;
    }
}
