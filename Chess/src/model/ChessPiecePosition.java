package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessPiecePosition {
    private Map<ChessPiece, List<Integer>> whiteChessPieceCurrentPosition;
    private Map<ChessPiece, List<Integer>> blackChessPieceCurrentPosition;
    private List<Integer> blackKingPosition;
    private List<Integer> whiteKingPosition;


    ChessPiecePosition(Board board){
        whiteChessPieceCurrentPosition = new HashMap<ChessPiece, List<Integer>>();
        blackChessPieceCurrentPosition = new HashMap<ChessPiece, List<Integer>>();
        blackKingPosition = new ArrayList<>(List.of(0,3));
        whiteKingPosition = new ArrayList<>(List.of(7,3));
        blackChessPieceCurrentPosition.put(board.getCell(0,0),new ArrayList<>(List.of(0,0)));  whiteChessPieceCurrentPosition.put(board.getCell(7,0),new ArrayList<>(List.of(7,0)));
        blackChessPieceCurrentPosition.put(board.getCell(0,1),new ArrayList<>(List.of(0,1)));  whiteChessPieceCurrentPosition.put(board.getCell(7,1),new ArrayList<>(List.of(7,1)));
        blackChessPieceCurrentPosition.put(board.getCell(0,2),new ArrayList<>(List.of(0,2)));  whiteChessPieceCurrentPosition.put(board.getCell(7,2),new ArrayList<>(List.of(7,2)));
        blackChessPieceCurrentPosition.put(board.getCell(0,4),new ArrayList<>(List.of(0,4)));  whiteChessPieceCurrentPosition.put(board.getCell(7,4),new ArrayList<>(List.of(7,4)));
        blackChessPieceCurrentPosition.put(board.getCell(0,5),new ArrayList<>(List.of(0,5)));  whiteChessPieceCurrentPosition.put(board.getCell(7,5),new ArrayList<>(List.of(7,5)));
        blackChessPieceCurrentPosition.put(board.getCell(0,6),new ArrayList<>(List.of(0,6)));  whiteChessPieceCurrentPosition.put(board.getCell(7,6),new ArrayList<>(List.of(7,6)));
        blackChessPieceCurrentPosition.put(board.getCell(0,7),new ArrayList<>(List.of(0,7)));  whiteChessPieceCurrentPosition.put(board.getCell(7,7),new ArrayList<>(List.of(7,7)));
        blackChessPieceCurrentPosition.put(board.getCell(1,0),new ArrayList<>(List.of(1,0)));  whiteChessPieceCurrentPosition.put(board.getCell(6,0),new ArrayList<>(List.of(6,0)));
        blackChessPieceCurrentPosition.put(board.getCell(1,1),new ArrayList<>(List.of(1,1)));  whiteChessPieceCurrentPosition.put(board.getCell(6,1),new ArrayList<>(List.of(6,1)));
        blackChessPieceCurrentPosition.put(board.getCell(1,2),new ArrayList<>(List.of(1,2)));  whiteChessPieceCurrentPosition.put(board.getCell(6,2),new ArrayList<>(List.of(6,2)));
        blackChessPieceCurrentPosition.put(board.getCell(1,3),new ArrayList<>(List.of(1,3)));  whiteChessPieceCurrentPosition.put(board.getCell(6,3),new ArrayList<>(List.of(6,3)));
        blackChessPieceCurrentPosition.put(board.getCell(1,4),new ArrayList<>(List.of(1,4)));  whiteChessPieceCurrentPosition.put(board.getCell(6,4),new ArrayList<>(List.of(6,4)));
        blackChessPieceCurrentPosition.put(board.getCell(1,5),new ArrayList<>(List.of(1,5)));  whiteChessPieceCurrentPosition.put(board.getCell(6,5),new ArrayList<>(List.of(6,5)));
        blackChessPieceCurrentPosition.put(board.getCell(1,6),new ArrayList<>(List.of(1,6)));  whiteChessPieceCurrentPosition.put(board.getCell(6,6),new ArrayList<>(List.of(6,6)));
        blackChessPieceCurrentPosition.put(board.getCell(1,7),new ArrayList<>(List.of(1,7)));  whiteChessPieceCurrentPosition.put(board.getCell(6,7),new ArrayList<>(List.of(6,7)));
    }

    public List<Integer> getKingPieceCurrentPosition(PlayerPieceType playerPieceType) {
        if(playerPieceType==PlayerPieceType.white) return whiteKingPosition;
        return blackKingPosition;
    }

    public Map<ChessPiece, List<Integer>> getAllChessPiecesHashmap(PlayerPieceType playerPieceType) {
        if(playerPieceType == PlayerPieceType.white) return whiteChessPieceCurrentPosition;
        return blackChessPieceCurrentPosition;
    }

    public void updateChessPieceCurrentPosition(ChessPiece chessPiece, int currentRow, int currentCol) {
        List<Integer> updateCurrentPosition = new ArrayList<>(List.of(currentRow,currentCol));
        if(chessPiece.getChessPieceColor()==PlayerPieceType.white){
            if(chessPiece.getChessPieceType()==ChessPieceType.king) whiteKingPosition = updateCurrentPosition;
            else whiteChessPieceCurrentPosition.replace(chessPiece, updateCurrentPosition);
        }
        else{
            if(chessPiece.getChessPieceType()==ChessPieceType.king) blackKingPosition = updateCurrentPosition;
            else blackChessPieceCurrentPosition.replace(chessPiece,updateCurrentPosition);
        }

    }
}
