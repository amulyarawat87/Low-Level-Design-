package model;

public class StandardRules extends Rules{

    @Override
    boolean checkWin(byte position) {
        return position==100;
    }

    @Override
    boolean isValidMove(byte position) {
        return position>=1 && position<=100;
    }

    @Override
    void checkSnakesLadders(byte position, SnakesLadders snakesladders, PieceType piece, Board board){
        if(piece != PieceType.p1 && piece != PieceType.p2) return ;

        if(snakesladders.getSnakes().containsKey(position)){
            System.out.println("Bad Luck caught by Snake");
            board.markPosition(snakesladders.getSnakes().get(position), piece);
        }
        else if(snakesladders.getLadders().containsKey(position)){
            System.out.println("Congrats you climb the Ladder");
            board.markPosition(snakesladders.getLadders().get(position), piece);
        }
    }

     void checkPlayerCross(byte position, PieceType piece, Board board){
        if(piece != PieceType.p1 && piece != PieceType.p2) return ;
        if(piece == PieceType.p1 && position == board.getPosition(PieceType.p2)) board.markPosition((byte) 0,PieceType.p2);
        else if(piece == PieceType.p2 && position == board.getPosition(PieceType.p1)) board.markPosition((byte) 0, PieceType.p1);

    }

}
