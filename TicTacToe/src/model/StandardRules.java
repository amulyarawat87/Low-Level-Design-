package model;

public class StandardRules extends Rules {

    public boolean checkWin(Board b, int row, int col, Piece p) {
        int boardlength = b.boardObj.length;
        //Diagonals
        int count =0;
        for(int i = 0; i < boardlength; i++) {
            if(b.boardObj[i][i]==p)
                count++;
        }
        if(count==3) return true;

        count = 0;
        for(int i = 0; i < boardlength; i++) {
            if(b.boardObj[i][boardlength-i-1]==p)
                count++;
        }
        if(count==3) return true;

        //Vertical
        count = 0;
        for(int i = 0; i < boardlength; i++) {
            if(b.boardObj[i][col]==p)
                count++;
        }
        if(count==3) return true;

        //Horizontal
        count = 0;
        for(int i = 0; i < boardlength; i++) {
            if(b.boardObj[row][i]==p)
                count++;
        }
        if(count==3) return true;

        return false;
    }

    public boolean checkDraw(Board b, int count) {
        for(int row = 0; row < b.boardObj.length; row++) {
            for (int col = 0; col < b.boardObj[row].length; col++) {
                if (b.isCellEmpty(row, col))
                    return false;
            }
        }
        return true;
    }

    public boolean isValidMove(Board b, int row, int col) {
        return row >= 0 && row < b.boardObj.length && col >= 0 && col < b.boardObj[row].length && b.boardObj[row][col] == null;
    }
}
