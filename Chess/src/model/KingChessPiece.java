package model;

public class KingChessPiece extends ChessPiece{
    public KingChessPiece(PlayerPieceType playerPieceType){
        super(ChessPieceType.king, playerPieceType, '\u2654');
    }

    @Override
    public boolean validMove(Board board, int sourceRow, int sourceCol, int destinationRow, int destinationCol) {
        return !(Math.abs(destinationRow-sourceRow)>1 || Math.abs(destinationCol-sourceCol)>1);
    }
}
