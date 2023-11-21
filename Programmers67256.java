import java.util.*;
class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    
}

class Solution {
    
    static String getLR(double leftabs,double rightabs,String hand){
        if(hand.equals("right") && leftabs == rightabs) return "R";
        if(hand.equals("left") && leftabs == rightabs) return "L";
        if(leftabs < rightabs) return "L";
        if(leftabs > rightabs) return "R";
        
        return "";
    }
    
static double getAbs(Point point, int index, List<Point> p_list) {
    Point middle = p_list.get(index);

    int x = point.getX();
    int y = point.getY();
    int x1 = middle.getX();
    int y1 = middle.getY();

    return Math.abs(x1 - x) + Math.abs(y1 - y); // 맨해튼 거리 계산
}
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        List<Point> p_list = new ArrayList<>();
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                p_list.add(new Point(i,j));
            }
        }
        
        List<Integer> left = List.of(1,4,7);
        List<Integer> right = List.of(3,6,9);
        List<Integer> middle = List.of(2,5,8,0);
            
        Stack<Point> leftHand = new Stack<>();
        Stack<Point> rightHand = new Stack<>();
        //왼손 오른손 초기위치 할당
        leftHand.push(new Point(3,0));
        rightHand.push(new Point(3,2));
        
        for(int i=0;i<numbers.length;i++){
           int index = (numbers[i] == 0) ? 10 : numbers[i] - 1;
            Point currPoint = p_list.get(index);

            if(left.contains(numbers[i])){
                answer.append("L");
                leftHand.push(currPoint);
            } else if(right.contains(numbers[i])){
                answer.append("R");
                rightHand.push(currPoint);
            } else {
                double leftabs = getAbs(leftHand.peek(), index, p_list);
                double rightabs = getAbs(rightHand.peek(), index, p_list);
                String chosenHand = getLR(leftabs, rightabs, hand);

                if(chosenHand.equals("L")){
                    leftHand.push(currPoint);
                } else {
                    rightHand.push(currPoint);
                }
                answer.append(chosenHand);
            }
        }
            
        return answer.toString();
    }
}
