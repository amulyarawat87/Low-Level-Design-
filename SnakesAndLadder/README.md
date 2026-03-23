# SnakesAndLadder

Console-based snakes and ladders game with board, dice, rules, players, and controller abstractions.

## Structure

- `src/Main.java`: Entry point.
- `src/model/`: Board entities and game logic.

## Build And Run

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

The game runs in the terminal using the configured standard rules.