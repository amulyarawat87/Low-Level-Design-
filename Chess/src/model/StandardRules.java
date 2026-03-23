package model;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class StandardRules extends Rules{
    @Override
    public boolean isValidMove(Board board, Player player, int sourceRow, int sourceCol, int destinationRow, int destinationCol) {
        ChessPiece sourceChessPiece = board.getCell(sourceRow, sourceCol);
        ChessPiece destinationChessPiece = board.getCell(destinationRow, destinationCol);

        if(sourceChessPiece==null) return false;
        if(player.getPlayerPiece().getPlayerPiece()!=sourceChessPiece.getChessPieceColor()) return false;

        if(destinationChessPiece!=null && destinationChessPiece.getChessPieceColor()==sourceChessPiece.getChessPieceColor()) return false;

        return sourceChessPiece.validMove(board, sourceRow, sourceCol, destinationRow, destinationCol);
    }

    @Override
    public boolean isPlayerCross(Board board, int destinationRow, int destinationCol){
        return board.getCell(destinationRow,destinationCol)!=null;
    }

    @Override
    public boolean regenerateChessPieceRequired(Board board, int destinationRow, int destinationCol) {
        ChessPiece currentChessPiece = board.getCell(destinationRow, destinationCol);
        return currentChessPiece.getChessPieceType()==ChessPieceType.pawn && ((destinationRow==0 && currentChessPiece.getChessPieceColor()==PlayerPieceType.white) || (destinationRow==7 && currentChessPiece.getChessPieceColor()==PlayerPieceType.black));
    }

    @Override
    public boolean check(Board board, Player player, ChessPiecePosition chessPiecePosition, Rules rules) {
        Map<ChessPiece, List<Integer>> piecesForCheck = chessPiecePosition.getAllChessPiecesHashmap(player.getPlayerPiece().getPlayerPiece());

        List<Integer> opponentKingPosition = chessPiecePosition.getKingPieceCurrentPosition(PlayerPieceType.white);
        if(player.getPlayerPiece().getPlayerPiece()==PlayerPieceType.white) opponentKingPosition = chessPiecePosition.getKingPieceCurrentPosition(PlayerPieceType.black);

        for(Map.Entry<ChessPiece, List<Integer>> itr : piecesForCheck.entrySet()){
           if(rules.isValidMove(board,player,itr.getValue().get(0),itr.getValue().get(1), opponentKingPosition.get(0), opponentKingPosition.get(1))) return true;
        }
        return false;
    }
}
