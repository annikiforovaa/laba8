import java.util.Scanner;


public class StringCalculator {

    private Fraction fraction1;
    private Fraction fraction2;
    private String sign;


    public StringCalculator(String fractionExpression) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] splitString = fractionExpression.split(" ");
            if (splitString.length != 3) {
                System.out.println("Incorrect input. Number of operators should be 3. Try again");
                fractionExpression = scanner.nextLine();
                continue;
            }
            fraction1 = new Fraction(splitString[0]);
            fraction2 = new Fraction(splitString[2]);

            if (!(splitString[1].equals("+") | splitString[1].equals("-")
                    | splitString[1].equals("*") | splitString[1].equals("/"))) {
                System.out.println("Incorrect input. Change the sign and try again");
                fractionExpression = scanner.nextLine();
                continue;
            } else {
                sign = splitString[1];
                break;
            }
        }
    }

    public Fraction getAnswer(){
        Fraction answer = new Fraction();

        switch(sign){

            case "+":
                answer = new Fraction(Fraction.sum(fraction1, fraction2));
                break;
            case "-":
                answer = new Fraction(Fraction.sub(fraction1, fraction2));
                break;
            case "*":
                answer = new Fraction(Fraction.multi(fraction1, fraction2));
                break;
            case "/":
                answer = new Fraction(Fraction.div(fraction1, fraction2));
                break;
        }

        return answer;


    }
}
