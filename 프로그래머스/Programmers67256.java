import java.util.*;
class Point {
    int x;
    int y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
// am 2:17 시작
class Solution {
    List<Integer> leftNumber = List.of(1,4,7);
    List<Integer> rightNumber = List.of(3,6,9);
        
    public String solution(int[] numbers, String hand) {
        int indexIng = 1;//10(*), 11(0), 12(#)
        Map<Integer,Point> maps = new HashMap<>();
        for(int i=0; i<4;i++){
            for(int j=0;j<3;j++){
                if(indexIng == 11) maps.put(0,new Point(i,j));
                 maps.put(indexIng++,new Point(i,j));
            }
        }
        Point leftHand = maps.get(10); //왼손초기위치 *
        Point rightHand = maps.get(12); //오른손초기위치 #
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<numbers.length;i++){
            if(leftNumber.contains(numbers[i])){
                result.append("L");
                leftHand = maps.get(numbers[i]);
                continue;
            }
            if(rightNumber.contains(numbers[i])){
                result.append("R");
                rightHand = maps.get(numbers[i]);
                continue;
            }
            Point p = maps.get(numbers[i]);
            int leftDistance = manDistance(leftHand,p);
            int rightDistance = manDistance(rightHand,p);
            //두손 거리가 같을경우(주손잡이의 따라 나눔)
            if(leftDistance == rightDistance && hand.equals("left")){
                result.append("L");
                leftHand = maps.get(numbers[i]);
            }
            if(leftDistance == rightDistance && hand.equals("right")){
                result.append("R");
                rightHand = maps.get(numbers[i]);
            }
            //왼손거리가 더 가까운경우
            if(leftDistance < rightDistance){
                result.append("L");
                leftHand = maps.get(numbers[i]);
            }
            //오른손거리가 더 가까운경우
            if(leftDistance > rightDistance){
                result.append("R");
                rightHand = maps.get(numbers[i]);
            }
        }
        
        
        return result.toString();
    }
    public static int manDistance(Point hand,Point p){
        int distance = Math.abs(hand.x - p.x) + Math.abs(hand.y - p.y);
        return distance;
    }
    
}
