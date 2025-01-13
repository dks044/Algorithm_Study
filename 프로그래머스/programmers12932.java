import java.util.*;
class Solution {
    //배열뒤집기
    public void reverseArr(int [] arr){
        int length = arr.length;
        for(int i=0;i<length/2;i++){
            int temp = arr[i];
            arr[i] = arr[length-i-1];
            arr[length-i-1] = temp;
        }
    }
    //배열만들기
    public int[] createArr(long n){
        String int_temp = String.valueOf(n);
        char[] int_tempToArr = int_temp.toCharArray();
        int[] create_arr = new int[int_tempToArr.length];
        for(int i=0;i<int_tempToArr.length;i++){
            create_arr[i] = int_tempToArr[i] - '0';
        }
        return create_arr;
    }
    
    
    public int[] solution(long n) {
        int[] answer = createArr(n);
        reverseArr(answer);
        return answer;
    }
}
