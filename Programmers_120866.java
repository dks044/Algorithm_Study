class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        int ssibal = board.length * board.length;
        int ssibal2 = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                ssibal2 += board[i][j];
            }
        }
        if (ssibal == ssibal2) {
            answer = 0;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    if (i + 1 < board.length && board[i + 1][j] != 1) board[i + 1][j] = 2;
                    if (j + 1 < board.length && board[i][j + 1] != 1) board[i][j + 1] = 2;
                    if (i + 1 < board.length && j + 1 < board.length && board[i + 1][j + 1] != 1) board[i + 1][j + 1] = 2;
                    if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] != 1) board[i + 1][j - 1] = 2;
                    if (i - 1 >= 0 && j + 1 < board.length && board[i - 1][j + 1] != 1) board[i - 1][j + 1] = 2;
                    if (i - 1 >= 0 && board[i - 1][j] != 1) board[i - 1][j] = 2;
                    if (j - 1 >= 0 && board[i][j - 1] != 1) board[i][j - 1] = 2;
                    if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] != 1) board[i - 1][j - 1] = 2;
                }
            }
        }
        int z_count = 0; //안전구역
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    z_count += 1;
                }
            }
        }

        System.out.println(z_count);
        return z_count;    }
}
