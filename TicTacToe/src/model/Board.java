package model;

public class Board {

    Piece[][] boardObj;

    public Board(){
        boardObj = new Piece[3][3];
    }
    public boolean isCellEmpty(int row, int col) {
        return boardObj[row][col] == null;
    }

    public Piece getCell(int row, int col) {
        return boardObj[row][col];
    }

    public void markCell(int row, int col, Piece p) {
        boardObj[row][col] = p;
    }

    public void displayBoard() {
        for(int row = 0; row < boardObj.length; row++){
            for(int col = 0; col < boardObj[row].length; col++){
                if (boardObj[row][col] != null){
                    System.out.print("  |  " + boardObj[row][col].getPiece());
                }
                else System.out.print("  |  " + (3*row+col+1));
            }
            System.out.print("  |  ");
            System.out.println();
        }
    }
}
