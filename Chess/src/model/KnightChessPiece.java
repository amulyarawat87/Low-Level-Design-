package model;

public class KnightChessPiece extends ChessPiece{
    public KnightChessPiece(PlayerPieceType playerPieceType){
        super(ChessPieceType.knight, playerPieceType, '\u2658');
    }

    @Override
    public boolean validMove(Board board, int sourceRow, int sourceCol, int destinationRow, int destinationCol) {
        if(Math.abs(destinationRow-sourceRow)==2 && Math.abs(destinationCol-sourceCol)==1) return true;
        if(Math.abs(destinationRow-sourceRow)==1 && Math.abs(destinationCol-sourceCol)==2) return true;

        return false;
    }
}
