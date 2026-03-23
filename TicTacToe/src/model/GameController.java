package model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GameController {
    Board board;
    Rules rules;
    Deque<Player> player;
    public GameController() {
        board = new Board();
        rules = new OptimalWinningStrategy();
        player = new ArrayDeque<>();

        initialInput();
    }

    void initialInput(){
        System.out.println("Welcome to Tic Tac Toe!");
        int chanceRandom = (int) (Math.random() * 2);
        Player p1 = new Player();
        Player p2 = new Player();
        Piece X = new XPiece();
        Piece O = new OPiece();
        Scanner input = new Scanner(System.in);

        //Player 1 Details Input
        System.out.println("Please enter Player 1 Details: ");
        System.out.print("Player 1 name: ");
        p1.setName(input.nextLine());
        if(chanceRandom > 0) p1.setPlayerPiece(X);
        else p1.setPlayerPiece(O);
        System.out.println("Player 1 piece: " + p1.getPlayerPiece().getPiece().name());
        System.out.println();

        //Player 2 Details Input
        System.out.println("Please enter Player 2 Details: ");
        System.out.print("Player 2 name: ");
        p2.setName(input.nextLine());
        if(chanceRandom > 0) p2.setPlayerPiece(O);
        else  p2.setPlayerPiece(X);
        System.out.println("Player 2 piece: " + p2.getPlayerPiece().getPiece().name());
        System.out.println();

        //Player Chance Order
        if(chanceRandom > 0) {
            System.out.println("Player " +p1.getName()+" Won the Toss");
            player.add(p1);
            player.add(p2);
        }
        else{
            System.out.println("Player " +p2.getName()+" Won the Toss");
            player.add(p2);
            player.add(p1);
        }
        System.out.println();
    }

    public void play() {
        System.out.println("Let the Game Begins !");
        Scanner input = new Scanner(System.in);
        int movescount = 0;
        while (true) {
            Piece playerPiece = player.getFirst().getPlayerPiece();
            String playerName = player.getFirst().getName();
            System.out.println();
            System.out.println("Player *** " + playerName + "'s **** Turn with Piece: " + playerPiece.getPiece().name());
            System.out.println();
            System.out.println("Please enter position of move(1-9): ");
            board.displayBoard();

            //Position Input
            int cellLocation = input.nextInt();
            int rowLocation = (cellLocation - 1) / 3;
            int colLocation = (cellLocation - 1) % 3;

            //Playing Logic
            if (rules.isValidMove(board, rowLocation, colLocation)) {
                board.markCell(rowLocation, colLocation, playerPiece);
                movescount++;
                if (rules.checkWin(board,rowLocation,colLocation,playerPiece)) {
                    System.out.println("Player " + playerName + " Won!");
                    break;
                } else if (rules.checkDraw(board,movescount)) {
                    System.out.println("Game Drawn!");
                    break;
                }
                Player currentPlayer = player.pop();
                player.add(currentPlayer);
            } else System.out.println("Invalid Move -- Try Again");

        }
    }
}
