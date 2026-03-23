package model;


public class Board {
    private byte p1Position;
    private byte p2Position;

    Board(){
        p1Position = 0;
        p2Position = 0;
    }

    byte getPosition(PieceType piece){
        if(piece == PieceType.p1) return p1Position;
        if(piece == PieceType.p2) return p2Position;
        return -1;
    }

    void markPosition(byte position, PieceType piece){
        if(piece == PieceType.p1) p1Position = position;
        else if(piece == PieceType.p2) p2Position = position;
    }
    void display(){
        for (int i=0; i<10; i++){
            for (int j = 1; j<=10; j++){
                if((10*i + j)==p1Position) System.out.print(" | p1 | ");
                else if((10*i + j)==p2Position) System.out.print(" | p2 | ");
                else System.out.print(" | " + (10*i + j) + " | ");
            }
            System.out.println();
        }
    }
}
