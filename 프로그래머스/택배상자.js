function solution(order) {
  let answer = 0;
  let stack = [];
  let current = 1;

  for (let i = 0; i < order.length; i++) {
    let target = order[i];

    // target이 나올 때까지 stack에 push
    while (current <= order.length && current <= target) {
      stack.push(current++);
    }

    // 스택 맨 위가 target이 맞으면 꺼냄
    if (stack[stack.length - 1] === target) {
      stack.pop();
      answer++;
    } else {
      break;
    }
  }

  return answer;
}
