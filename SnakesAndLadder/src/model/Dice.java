package model;

public class Dice {
    private final byte numbersOnDice = 6;

    byte rollDice(){
        byte diceCurrentNumber = (byte) (Math.random() * numbersOnDice);
        return diceCurrentNumber==0 ? 1 : diceCurrentNumber;
    }

}
