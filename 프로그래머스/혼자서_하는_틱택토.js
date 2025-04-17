function solution(board) {
    let count_o = 0;
    let count_x = 0;

    // O, X 개수 세기
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            if (board[i][j] === 'O') count_o++;
            if (board[i][j] === 'X') count_x++;
        }
    }

    const oWin = isWin(board, 'O');
    const xWin = isWin(board, 'X');

    // 개수 체크
    if (count_x > count_o) return 0;
    if (count_o > count_x + 1) return 0;

    // 둘 다 이긴 경우 불가
    if (oWin && xWin) return 0;

    // O가 이겼는데 개수 불일치
    if (oWin && count_o !== count_x + 1) return 0;

    // X가 이겼는데 개수 불일치
    if (xWin && count_o !== count_x) return 0;

    return 1;
}

function isWin(board, word) {
    // 가로, 세로
    for (let i = 0; i < 3; i++) {
        if (board[i][0] === word && board[i][1] === word && board[i][2] === word) return true;
        if (board[0][i] === word && board[1][i] === word && board[2][i] === word) return true;
    }

    // 대각선
    if (board[0][0] === word && board[1][1] === word && board[2][2] === word) return true;
    if (board[0][2] === word && board[1][1] === word && board[2][0] === word) return true;

    return false;
}
