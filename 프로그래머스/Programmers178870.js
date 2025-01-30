function solution(sequence, k) {
    var answer = [];
    let sum = 0; // 초기 합을 0으로 설정
    let left = 0;
    let minLength = Number.MAX_VALUE;
    let start = -1; // 시작 인덱스
    let end = -1; // 끝 인덱스

    for (let right = 0; right < sequence.length; right++) {
        sum += sequence[right];

        // sum이 k보다 커질 때까지 left 인덱스를 증가
        while (sum > k) {
            sum -= sequence[left];
            left++;
        }

        // sum이 k와 같을 때
        if (sum === k) {
            let length = right - left + 1; // 부분 수열의 길이
            if (length < minLength) {
                minLength = length;
                start = left; // 시작 인덱스 저장
                end = right; // 끝 인덱스 저장
            }
        }
    }

    return [start, end]; // 최종 결과 반환
}
