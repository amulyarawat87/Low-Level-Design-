package model;

public class Player {
    private String name;
    private PlayerPiece playerPiece;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerPiece getPlayerPiece() {
        return playerPiece;
    }

    public void setPlayerPiece(PlayerPiece playerPiece) {
        this.playerPiece = playerPiece;
    }
}
