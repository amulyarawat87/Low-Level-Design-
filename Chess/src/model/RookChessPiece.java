package model;

public class RookChessPiece extends ChessPiece{
    public RookChessPiece(PlayerPieceType playerPieceType){
        super(ChessPieceType.rook, playerPieceType, '\u2656');
    }

    @Override
    public boolean validMove(Board board, int sourceRow, int sourceCol, int destinationRow, int destinationCol) {
        if(sourceRow!=destinationRow && sourceCol!=destinationCol) return false;

        if(sourceRow==destinationRow){
            int startCol = Math.min(sourceCol,destinationCol), endCol = Math.max(sourceCol,destinationCol);
            for(int i=startCol+1; i<endCol; i++){
                if(board.getCell(sourceRow,i)!=null) return false;
            }
        }
        else{
            int startRow = Math.min(sourceRow,destinationRow), endRow = Math.max(sourceRow,destinationRow);
            for(int i=startRow+1; i<endRow; i++){
                if(board.getCell(i,sourceCol)!=null) return false;
            }
        }
        return true;
    }
}
