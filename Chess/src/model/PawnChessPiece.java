package model;

public class PawnChessPiece extends ChessPiece{
    private boolean singleMove = false;
    public PawnChessPiece(PlayerPieceType playerPieceType){
        super(ChessPieceType.pawn, playerPieceType, '\u2659');

    }

    @Override
    public boolean validMove(Board board, int sourceRow, int sourceCol, int destinationRow, int destinationCol) {
        ChessPiece sourceChessPiece = board.getCell(sourceRow, sourceCol);
        ChessPiece destinationChessPiece = board.getCell(destinationRow, destinationCol);

        if(Math.abs(destinationCol-sourceCol) > 1) return false;
        if(Math.abs(destinationCol-sourceCol)==1 && destinationChessPiece==null) return false;
        if(destinationCol==sourceCol && destinationChessPiece!=null) return false;

        if(sourceChessPiece.getChessPieceColor()==PlayerPieceType.white && (sourceRow-destinationRow<1 || sourceRow-destinationRow>2)) return false;
        if(sourceChessPiece.getChessPieceColor()==PlayerPieceType.black && (destinationRow-sourceRow<1 || destinationRow-sourceRow>2)) return false;
        if(Math.abs(destinationRow-sourceRow)==2 && singleMove) return false;
        if(Math.abs(destinationRow-sourceRow)==1) singleMove = true;

        return true;
    }
}
