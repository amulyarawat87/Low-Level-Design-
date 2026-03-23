package model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GameController {
    Board board;
    Rules rules;
    Dice dice;
    SnakesLadders snakesladders;
    Deque<Player> player;

    public GameController(){
        board = new Board();
        rules = new StandardRules();
        dice = new Dice();
        snakesladders = new SnakesLadders();
        player = new ArrayDeque<>();

        initialInput();
    }
    void initialInput(){
        int chanceRandom = (int) (Math.random() * 2);
        Player player1 = new Player();
        Player player2 = new Player();

        Piece P1 = new P1Piece();
        Piece P2 = new P2Piece();


        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Snakes And Ladders");
        System.out.println("Enter Player 1 Details: ");
        System.out.print("Name: ");
        player1.setName(input.nextLine());
        player1.setPlayerPiece(P1);

        System.out.println();

        System.out.println("Enter Player 2 Details: ");
        System.out.print("Name: ");
        player2.setName(input.nextLine());
        player2.setPlayerPiece(P2);

        //Player Chance Order
        if(chanceRandom > 0) {
            System.out.println("Player " +player1.getName()+" Won the Toss");
            player.add(player1);
            player.add(player2);
        }
        else{
            System.out.println("Player " +player2.getName()+" Won the Toss");
            player.add(player2);
            player.add(player1);
        }

    }
    public void play(){
        System.out.println("Let the Game Begins !");
        Scanner input = new Scanner(System.in);
        boolean gameOver = false;
        while(!gameOver){
            String playerName = player.getFirst().getName();
            PieceType playerPiece = player.getFirst().getPlayerPiece().getPiece();
            System.out.println();
            System.out.println("Player *** " + playerName + "'s **** Turn with Piece: " + playerPiece.name());
            System.out.println();
            board.display();
            System.out.println();
            System.out.println("Press Enter to roll Dice");
            byte inputRollDice = input.nextByte(); //To take input
//            byte diceNumber = dice.rollDice();
            byte diceNumber = inputRollDice;
            while(diceNumber%6==0){
                System.out.println("You got 6, Press Enter Again to Roll");
                inputRollDice = input.nextByte();
                if(diceNumber%18==0) diceNumber = 0;
                diceNumber+=inputRollDice;
            }
            System.out.println("You got " + diceNumber);

            byte currentPlayerPosition = (byte) (board.getPosition(playerPiece) + diceNumber);
            if(rules.isValidMove(currentPlayerPosition)){
                board.markPosition(currentPlayerPosition, playerPiece);
                if(rules.checkWin(board.getPosition(playerPiece))){
                    System.out.println("Player "+ playerName + "  Won");
                    gameOver = true;
                }
                rules.checkSnakesLadders(board.getPosition(playerPiece), snakesladders, playerPiece, board);
                rules.checkPlayerCross(currentPlayerPosition, playerPiece, board);
                Player currentPlayer = player.pop();
                player.add(currentPlayer);
            }
            else System.out.println("You cannot Move further Now. Wait For next turn!!");
        }
    }
}
