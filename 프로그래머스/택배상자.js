function solution(order) {
    let answer = 0;
    let container = Array.from({ length: order.length }, (_, index) => index + 1);
    let subContainer = [];

    let orderIndex = 0;

    for (let i = 0; i < order.length; i++) {
        let box = container[i];

        // 컨테이너에서 상자 하나씩 순서대로 처리
        subContainer.push(box);

        // 트럭에 실을 수 있을 때까지 계속 실음
        while (subContainer.length && subContainer[subContainer.length - 1] === order[orderIndex]) {
            subContainer.pop();
            answer++;
            orderIndex++;
        }
    }

    return answer;
}
