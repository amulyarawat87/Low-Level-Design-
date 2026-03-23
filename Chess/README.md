# Chess

Console-based chess design project with board state, pieces, rules, and game controller classes.

## Structure

- `src/Main.java`: Entry point.
- `src/model/`: Core chess model and rules implementation.

## Build And Run

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

## Notes

- The current `Main` file includes temporary boolean print statements.
- To run game flow, use the `GameController` call in `Main`.