# MortgageCalculator

Interactive Java console application that calculates a monthly mortgage payment.

## Inputs

- Principal: between 1,000 and 1,000,000
- Annual Interest Rate: between 0 and 30
- Period (years): between 1 and 30

## Output

- Monthly mortgage payment formatted as currency.

## Build And Run

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```