function solution(topping) {
    let answer = 0;

    const left = new Map();   // 철수 쪽
    const right = new Map();  // 동생 쪽

    // 처음엔 전부 동생 쪽에 있음
    for (let t of topping) {
        right.set(t, (right.get(t) || 0) + 1);
    }

    for (let i = 0; i < topping.length - 1; i++) {
        const t = topping[i];

        // 철수 쪽에 추가
        left.set(t, (left.get(t) || 0) + 1);

        // 동생 쪽에서 제거
        right.set(t, right.get(t) - 1);
        if (right.get(t) === 0) {
            right.delete(t);
        }

        // 종류 수 비교
        if (left.size === right.size) {
            answer++;
        }
    }

    return answer;
}
