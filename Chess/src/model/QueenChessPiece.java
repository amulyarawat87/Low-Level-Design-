package model;

public class QueenChessPiece extends ChessPiece{
    public QueenChessPiece(PlayerPieceType playerPieceType){
        super(ChessPieceType.queen, playerPieceType, '\u2655');
    }

    @Override
    public boolean validMove(Board board, int sourceRow, int sourceCol, int destinationRow, int destinationCol) {
        
        ChessPiece bishopPiece = new BishopChessPiece(board.getCell(sourceRow,sourceCol).getChessPieceColor());
        ChessPiece rookPiece = new RookChessPiece(board.getCell(sourceRow,sourceCol).getChessPieceColor());
        
        return bishopPiece.validMove(board, sourceRow, sourceCol, destinationRow, destinationCol) || rookPiece.validMove(board, sourceRow, sourceCol, destinationRow, destinationCol);
        
    }
}
