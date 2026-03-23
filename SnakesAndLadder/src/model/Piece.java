package model;

public class Piece {
    private final PieceType piece;
    Piece(PieceType piece){
        this.piece = piece;
    }
    PieceType getPiece(){
        return this.piece;
    }
}
