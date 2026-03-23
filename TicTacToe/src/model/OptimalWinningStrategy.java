package model;

import static model.PieceType.X;

public class OptimalWinningStrategy extends Rules{
    int [] horizontalRow;
    int [] verticalCol;
    int diag = 0;
    int antidiag = 0;

    OptimalWinningStrategy(){
        horizontalRow = new int[3];
        verticalCol = new int[3];
    }
    @Override
    public boolean checkWin(Board b, int row, int col, Piece p) {
        if (p.getPiece()==X){
            horizontalRow[row]++;
            verticalCol[col]++;
            if(row==col) diag++;
            if(row+col == 2) antidiag++;
        }
        else{
            horizontalRow[row]--;
            verticalCol[col]--;
            if(row==col) diag--;
            if(row+col == 2) antidiag--;
        }
        return diag == 3 || diag == -3 || antidiag == 3 || antidiag == -3 || horizontalRow[row] == 3 || verticalCol[col] == 3 || horizontalRow[row] == -3 || verticalCol[col] == -3;
    }

    @Override
    public boolean checkDraw(Board b, int count) {
        return count==9;
    }

    @Override
    public boolean isValidMove(Board b, int row, int col) {
        return row >= 0 && row < b.boardObj.length && col >= 0 && col < b.boardObj[row].length && b.boardObj[row][col] == null;
    }
}
