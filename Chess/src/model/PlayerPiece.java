package model;

public class PlayerPiece {
    private PlayerPieceType piece;
    PlayerPiece(PlayerPieceType piece){
        this.piece = piece;
    }

    PlayerPieceType getPlayerPiece(){
        return this.piece;
    }
}
