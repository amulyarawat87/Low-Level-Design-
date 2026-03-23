package model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GameController {
    Board board;
    Rules rules;
    ChessPiecePosition chessPiecePosition;
    Deque<Player> player;

    public GameController(){
        board = new Board();
        rules = new StandardRules();
        chessPiecePosition = new ChessPiecePosition(board);
        player = new ArrayDeque<>();
        initialiseGame();
    }

    public void initialiseGame(){
        Scanner input = new Scanner(System.in);

        Player player1 = new Player();
        Player player2 = new Player();


        PlayerPiece blackPiece = new BlackPlayerPiece();
        PlayerPiece whitePiece = new WhitePlayerPiece();

        System.out.println("Welcome to Chess");
        System.out.println("Enter Player 1 Details: ");
        System.out.print("Name: ");
        player1.setName(input.nextLine());
        player1.setPlayerPiece(whitePiece);

        System.out.println();

        System.out.println("Enter Player 2 Details: ");
        System.out.print("Name: ");
        player2.setName(input.nextLine());
        player2.setPlayerPiece(blackPiece);

        player.add(player1);
        player.add(player2);
    }
    public boolean isValidInput(String sourcePlayerInput, String destinationPlayerInput){
        if(sourcePlayerInput.length()!=2 || destinationPlayerInput.length()!=2) return false;
        int sourceRow = sourcePlayerInput.charAt(1)-'1', sourceCol = sourcePlayerInput.charAt(0)-'a';
        int destinationRow = destinationPlayerInput.charAt(1)-'1', destinationCol = destinationPlayerInput.charAt(0)-'a';

        return sourceRow>=0 && sourceRow<=7 && sourceCol>=0 && sourceCol<=7 && destinationRow>=0 && destinationRow<=7 && destinationCol>=0 && destinationCol<=7;

    }
    public void play(){
        System.out.println("Let the Game Begins !");
        Scanner input = new Scanner(System.in);
        boolean gameOver = false;
        while(!gameOver){
            board.display();
            String playerName = player.getFirst().getName();
            PlayerPieceType playerPieceType = player.getFirst().getPlayerPiece().getPlayerPiece();

            System.out.println();
            System.out.println();
            System.out.println("Player *** " + playerName + "'s **** Turn with Piece: " + playerPieceType.name());
            System.out.println();
            System.out.print("Enter Source Position : ");
            String sourcePlayerInput = input.next().toLowerCase();
            System.out.print("Enter Destination Position : ");
            String destinationPlayerInput = input.next().toLowerCase();

            if(isValidInput(sourcePlayerInput, destinationPlayerInput)){
                int sourceRow = sourcePlayerInput.charAt(1)-'1', sourceCol = sourcePlayerInput.charAt(0)-'a';
                int destinationRow = destinationPlayerInput.charAt(1)-'1', destinationCol = destinationPlayerInput.charAt(0)-'a';
                if(rules.check(board,player.getFirst(),chessPiecePosition,rules)){
                    System.out.println();
                    System.out.println("------------CHECK ALERT-------------");
                    System.out.println("-----Player : "+playerName+ " with Piece: "+ playerPieceType.name()+ " is currently on Check. Please Save your King-----");
                    System.out.println();
                }
                if(rules.isValidMove(board, player.getFirst(), sourceRow, sourceCol, destinationRow, destinationCol)) {
                    System.out.println();
                    if(rules.isPlayerCross(board, destinationRow, destinationCol)){
                        System.out.print("Piece : " +board.getCell(destinationRow,destinationCol).getChessPieceColor().name() + " " +board.getCell(destinationRow,destinationCol).getChessPieceType().name() +" is Killed By "+playerName);
                        System.out.println();
                    }
                    board.setCell(board.getCell(sourceRow, sourceCol), destinationRow, destinationCol);
                    board.setCell(null, sourceRow, sourceCol);
                    chessPiecePosition.updateChessPieceCurrentPosition(board.getCell(sourceRow, sourceCol), destinationRow, destinationCol);

                    if(rules.regenerateChessPieceRequired(board, destinationRow, destinationCol)){
                        ChessPiece regeneratedChessPiece = null;
                        ChessPiece currentChessPiece = board.getCell(destinationRow, destinationCol);
                        while(regeneratedChessPiece==null) {
                            System.out.println("Please Enter Piece to be Regenerated (queen, rook, bishop, knight, pawn): ");
                            String chessPiece = input.next().toLowerCase();
                            if (chessPiece.equals(ChessPieceType.queen.name()))
                                regeneratedChessPiece = new QueenChessPiece(currentChessPiece.getChessPieceColor());
                            else if (chessPiece.equals(ChessPieceType.rook.name()))
                                regeneratedChessPiece = new RookChessPiece(currentChessPiece.getChessPieceColor());
                            else if (chessPiece.equals(ChessPieceType.bishop.name()))
                                regeneratedChessPiece = new BishopChessPiece(currentChessPiece.getChessPieceColor());
                            else if (chessPiece.equals(ChessPieceType.knight.name()))
                                regeneratedChessPiece = new KnightChessPiece(currentChessPiece.getChessPieceColor());
                            else if (chessPiece.equals(ChessPieceType.pawn.name())) regeneratedChessPiece = currentChessPiece;
                            else System.out.println("Invalid Chess Piece ---");
                            System.out.println();
                        }
                        board.setCell(regeneratedChessPiece, destinationRow, destinationCol);
                    }

                    Player currentPlayer = player.pop();
                    player.add(currentPlayer);
                }
                else System.out.print("Invalid Move ----- Try Again !!");
            }
            else{
                System.out.print("----------------Invalid Input------------");
                System.out.print("Input Format (for both source and destination) : E(position A-F) 1(number 1-8)");
            }
            System.out.println();
        }
    }
}
