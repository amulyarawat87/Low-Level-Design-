package model;

public class Piece{
    PieceType pieceType;
    Piece(PieceType p){
        this.pieceType = p;
    }
    public PieceType getPiece(){
        return this.pieceType;
    };
}



