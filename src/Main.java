import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);

        String fractionExpression = scanner.nextLine();
        StringCalculator expression = new StringCalculator(fractionExpression);
        System.out.println("The result is: " + expression.getAnswer());
    }
}
