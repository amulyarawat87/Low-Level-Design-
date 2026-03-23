package model;

abstract public class Rules {
    ChessPiece chessPiece;
    abstract public boolean isValidMove(Board board, Player player, int sourceRow, int sourceCol, int destinationRow, int destinationCol);
    abstract public boolean isPlayerCross(Board board, int destinationRow, int destinationCol);
    abstract public boolean regenerateChessPieceRequired(Board board , int destinationRow, int destinationCol);
    abstract public boolean check(Board board, Player player, ChessPiecePosition chessPiecePosition, Rules rules);
}
