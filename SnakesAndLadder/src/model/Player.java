package model;

public class Player {
    private String playername;
    private Piece playerpiece;

    public String getName() {
        return playername;
    }

    public void setName(String playername) {
        this.playername = playername;
    }

    public Piece getPlayerPiece() {
        return playerpiece;
    }

    public void setPlayerPiece(Piece playerpiece) {
        this.playerpiece = playerpiece;
    }
}
