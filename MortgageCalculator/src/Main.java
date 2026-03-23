//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.text.NumberFormat;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENTAGE = 100;

        Scanner input = new Scanner(System.in);

        System.out.print("Principal: ");
        float principal = input.nextFloat();

        while (principal<1000 || principal>1000000){
            System.out.println("Enter a number between 1,000 and 1,000,000");
            System.out.print("Principal: ");
            principal = input.nextFloat();;
        }

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = input.nextFloat();
        while(annualInterestRate<0 || annualInterestRate>30){
            System.out.println("Enter a number between 0 and 30");
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = input.nextFloat();
        }
        float monthlyInterestRate = annualInterestRate / (MONTHS_IN_A_YEAR*PERCENTAGE);

        System.out.print("Periods (in years): ");
        byte period = input.nextByte();
        while(period<1 || period > 30){
            System.out.println("Enter a number between 1 and 30");
            System.out.print("Periods (in years): ");
            period = input.nextByte();
        }
        int numberOfPayments = period * MONTHS_IN_A_YEAR;

        double powerVariable = Math.pow((1 + monthlyInterestRate), numberOfPayments);

        double mortgage = (principal * monthlyInterestRate * powerVariable) / (powerVariable - 1);
        NumberFormat mortgageFormatted = NumberFormat.getCurrencyInstance();
        System.out.print("Mortgage: " + mortgageFormatted.format(mortgage));


    }
}