package model;

public class Player{
    String name;
    Piece piece;

    public String getName() {
        return name;
    }

    public Piece getPlayerPiece() {
        return piece;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerPiece(Piece piece) {
        this.piece = piece;
    }

}
