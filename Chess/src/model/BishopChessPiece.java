package model;

public class BishopChessPiece extends ChessPiece{
    public BishopChessPiece(PlayerPieceType playerPieceType){
        super(ChessPieceType.bishop,playerPieceType,'\u2657');
    }

    @Override
    public boolean validMove(Board board, int sourceRow, int sourceCol, int destinationRow, int destinationCol) {
        if(Math.abs(sourceRow-destinationRow) != Math.abs(sourceCol-destinationCol)) return false;

        int startRow = Math.min(sourceRow,destinationRow), endRow = Math.max(sourceRow, destinationRow);
        int startCol = (sourceRow<destinationRow) ? (sourceCol) : (destinationCol) , endCol = (sourceRow>destinationRow) ? sourceCol : destinationCol;


        while(startRow<endRow && startCol<endCol){
            if(board.getCell(startRow,endRow)!=null && startRow!=sourceRow && startCol!=sourceCol) return false;
            startRow++; startCol++;
        }

        return true;
    }
}
