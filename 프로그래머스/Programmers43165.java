class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,0,target);
        return answer;
    }
    static void dfs(int[] numbers,int depth, int sum, int target){
        if(depth == numbers.length){
            if(sum == target) {
                answer++;
            }
            return;
        }else{
            dfs(numbers,depth + 1, sum + numbers[depth], target);
            dfs(numbers,depth + 1, sum - numbers[depth], target);
        }
    }
}
