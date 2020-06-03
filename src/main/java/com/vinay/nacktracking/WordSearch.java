package com.vinay.nacktracking;

public class WordSearch {
    public int rows;
    public int cols;
    char[] wordChar;
    int rowOffSet[] = {0, -1, 0, 1};
    int colOffSet[] = {1, 0, -1, 0};
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        this.wordChar = word.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (wordSearch(i, j, board, 0))
                    return true;
                System.out.println("completed");
            }
        }
        return false;
    }

    private boolean wordSearch(int row, int col, char[][] board, int index) {
        if (index >= wordChar.length)
            return true;

        if (row < 0 || col < 0 || row >= this.rows || col>= this.cols || board[row][col] != wordChar[index])
            return false;
        board[row][col] = '#';
        System.out.println(wordChar[index]);
        boolean returnValue = false;
        for (int i = 0; i < 4; i++) {
            returnValue = wordSearch(row+rowOffSet[i], col+colOffSet[i], board, index+1);
            if (returnValue)
                break;
        }
        board[row][col] = wordChar[index];
        return returnValue;
    }
}
