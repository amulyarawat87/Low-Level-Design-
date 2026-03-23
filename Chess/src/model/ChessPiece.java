package model;

public class ChessPiece {
    private ChessPieceType piece;
    private PlayerPieceType pieceColor;
    private char chessPieceSymbol;

    public ChessPiece(ChessPieceType chessPiece, PlayerPieceType playerPieceType, char chessPieceSymbol){
        this.piece = chessPiece;
        this.pieceColor = playerPieceType;
        this.chessPieceSymbol = chessPieceSymbol;
    }
    public ChessPieceType getChessPieceType(){
        return this.piece;
    }
    public PlayerPieceType getChessPieceColor(){
        return this.pieceColor;
    }
    public char getChessPieceSymbol() {
        return this.chessPieceSymbol;
    }
    public boolean validMove(Board board, int sourceRow, int sourceCol, int destinationRow, int destinationCol){
        return false;
    }

}
