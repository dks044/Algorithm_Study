class Solution {
    public String solution(int a, int b) {
        int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        //금요일부터 시작하니까, 배열의 시작은 FRI로 함.
        String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        
        int sumDay = b;
        //ex)3월일경우 1월,2월 하면 됨.
        for(int i=0;i<a-1;i++){
            sumDay += dayOfMonth[i];
        }
        
        //배열의 인덱스는 0부터 시작하기떄문에 -1
        return week[(sumDay-1)%7];
    }
}
