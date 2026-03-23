package model;

public class Board {
    private final ChessPiece[][] board;

    public Board(){
        board = new ChessPiece[8][8];
        board[0][0] = new RookChessPiece(PlayerPieceType.black); board[7][0] = new RookChessPiece(PlayerPieceType.white);;
        board[0][1] = new KnightChessPiece(PlayerPieceType.black); board[7][1] = new KnightChessPiece(PlayerPieceType.white);;
        board[0][2] = new BishopChessPiece(PlayerPieceType.black); board[7][2] = new BishopChessPiece(PlayerPieceType.white);;
        board[0][3] = new KingChessPiece(PlayerPieceType.black); board[7][3] = new KingChessPiece(PlayerPieceType.white);
        board[0][4] = new QueenChessPiece(PlayerPieceType.black);; board[7][4] =  new QueenChessPiece(PlayerPieceType.white);;
        board[0][5] = new BishopChessPiece(PlayerPieceType.black);; board[7][5] = new BishopChessPiece(PlayerPieceType.white);;
        board[0][6] = new KnightChessPiece(PlayerPieceType.black);; board[7][6] = new KnightChessPiece(PlayerPieceType.white);;
        board[0][7] = new RookChessPiece(PlayerPieceType.black);; board[7][7] = new RookChessPiece(PlayerPieceType.white);;
        board[1][0] = new PawnChessPiece(PlayerPieceType.black); board[6][0] = new PawnChessPiece(PlayerPieceType.white);
        board[1][1] = new PawnChessPiece(PlayerPieceType.black); board[6][1] = new PawnChessPiece(PlayerPieceType.white);
        board[1][2] = new PawnChessPiece(PlayerPieceType.black); board[6][2] = new PawnChessPiece(PlayerPieceType.white);
        board[1][3] = new PawnChessPiece(PlayerPieceType.black); board[6][3] = new PawnChessPiece(PlayerPieceType.white);
        board[1][4] = new PawnChessPiece(PlayerPieceType.black); board[6][4] = new PawnChessPiece(PlayerPieceType.white);
        board[1][5] = new PawnChessPiece(PlayerPieceType.black); board[6][5] = new PawnChessPiece(PlayerPieceType.white);
        board[1][6] = new PawnChessPiece(PlayerPieceType.black); board[6][6] = new PawnChessPiece(PlayerPieceType.white);
        board[1][7] = new PawnChessPiece(PlayerPieceType.black); board[6][7] = new PawnChessPiece(PlayerPieceType.white);
    }

    public void setCell(ChessPiece chessPiece, int row, int col){
        board[row][col] = chessPiece;
    }

    public ChessPiece getCell(int row, int col){
        return board[row][col];
    }

    public void display(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(j==0) System.out.print((i + 1));
                if(board[i][j]==null)  System.out.print(" | " + Character.toString('\u2003') +" | ");
                else{
                    char chessPieceUnicode = board[i][j].getChessPieceSymbol();
                    if(board[i][j].getChessPieceColor()==PlayerPieceType.black) chessPieceUnicode+=6;
                    System.out.print(" | " +chessPieceUnicode+" | ");
                }
            }
            System.out.println();
        }

        for(int i=0; i<8; i++) {
            if (i == 0) System.out.print("    " + Character.toString('\u0041'+i));
            else System.out.print("      " + Character.toString('\u2007') + Character.toString('\u0041'+i));
        }
    }

}
