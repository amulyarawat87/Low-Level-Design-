package model;

public abstract class Rules {
    abstract boolean checkWin(byte position);
    abstract boolean isValidMove(byte position);
    abstract void checkSnakesLadders(byte position, SnakesLadders snakesladders, PieceType piece, Board board);
    abstract void checkPlayerCross(byte position, PieceType piece, Board board);
}
