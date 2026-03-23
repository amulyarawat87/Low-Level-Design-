package model;

public abstract class Rules{
    public abstract boolean checkWin(Board b, int row, int col, Piece p);
    public abstract boolean checkDraw(Board b, int count);
    public abstract boolean isValidMove(Board b, int row, int col);
}
