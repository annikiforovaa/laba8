
import java.util.Scanner;
import java.util.regex.Matcher;

///Создание простой дроби (с заданным числителем и знаменателем)
//Создание простой дроби по умолчанию (числитель 1, знаменатель 1)
///Операция сложения (2 варианта: в первом - функция возвращает результат сложения двух дробей, указанных как аргументы, во втором - аргумент только один)
//Операция вычитания (2 варианта: в первом - функция возвращает результат вычитания двух дробей, указанных как аргументы, во втором - аргумент только один)
//Операция умножения (2 варианта: в первом - функция возвращает результат умножения двух дробей, указанных как аргументы, во втором - аргумент только один)
//Операция деления (2 варианта: в первом - функция возвращает результат деления двух дробей, указанных как аргументы, во втором - аргумент только один)
public class Fraction {
    protected int numerator;
    protected int denominator;

    public Fraction(int num, int den){
        this.numerator = num/gcd(num, den);
        this.denominator = den/gcd(num, den);
    }
    public Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(Fraction fraction){
        this.numerator = fraction.numerator;
        this.denominator = fraction.denominator;
    }

    public Fraction(String fraction){

        String[] fractionString = fraction.split("/");
        if (fractionString.length != 2 ){
            System.out.println("Incorrect Fraction. Please restart and try again");
            System.exit(1);
        }
        else{
            if (fractionString[1].equals("0")){
                System.out.println("Can't divide by zero. Please restart and try again");
                System.exit(1);
            }
            try {
                int tempNum = Integer.parseInt(fractionString[0]);
                int tempDen = Integer.parseInt(fractionString[1]);
                this.numerator = tempNum/gcd(tempNum, tempDen);
                this.denominator = tempDen/gcd(tempNum, tempDen);
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect Fraction");
                System.exit(2);
            }
        }
    }

    public static int gcd(int numerator, int denominator) { //greatest common divisor - gcd
        while (denominator != 0) {
            int temp = denominator;
            denominator = numerator % denominator;
            numerator = temp;
        }
        return numerator;
    }

    public static int lcm(int numerator, int denominator) { //least common multiple - lcm
        return numerator / gcd(numerator, denominator) * denominator;
    }


    public static Fraction sum(Fraction firstFraction, Fraction secondFraction){ //Summation or addition
        int rDenominator = lcm(firstFraction.denominator, secondFraction.denominator);
        int rNumerator = firstFraction.numerator * (rDenominator / firstFraction.denominator) +
                secondFraction.numerator * (rDenominator / secondFraction.denominator);

        return new Fraction(rNumerator, rDenominator);
    }

    public static Fraction sub(Fraction firstFraction, Fraction secondFraction){ //Subtraction
        int rDenominator = lcm(firstFraction.denominator, secondFraction.denominator);
        int rNumerator = firstFraction.numerator * (rDenominator /firstFraction.denominator) -
                secondFraction.numerator * (rDenominator / secondFraction.denominator);
        return new Fraction(rNumerator, rDenominator);
    }

    public static Fraction multi(Fraction firstFraction, Fraction secondFraction){ //Multiplication
        int rNumerator = firstFraction.numerator * secondFraction.numerator;
        int rDenominator = firstFraction.denominator * secondFraction.denominator;
        return new Fraction(rNumerator, rDenominator);
    }

    public static Fraction div(Fraction firstFraction, Fraction secondFraction){ //Division
        int rNumerator = firstFraction.numerator * secondFraction.denominator;
        int rDenominator = firstFraction.denominator * secondFraction.numerator;
        return new Fraction(rNumerator, rDenominator);
    }

    public Fraction sum(Fraction secondFraction){
        int rDenominator = lcm(denominator, secondFraction.denominator);
        int rNumerator = numerator * (rDenominator /denominator) +
                secondFraction.numerator * (rDenominator / secondFraction.denominator);
        return new Fraction(rNumerator, rDenominator);
    }

    public Fraction sub(Fraction secondFraction){
        int rDenominator = lcm(denominator, secondFraction.denominator);
        int rNumerator = numerator * (rDenominator /denominator) -
                secondFraction.numerator * (rDenominator / secondFraction.denominator);
        return new Fraction(rNumerator, rDenominator);
    }

    public Fraction multi(Fraction secondFraction){
        int rNumerator = numerator * secondFraction.numerator;
        int rDenominator = denominator * secondFraction.denominator;
        return new Fraction(rNumerator, rDenominator);
    }

    public Fraction div(Fraction secondFraction){
        int rNumerator = numerator * secondFraction.denominator;
        int rDenominator = denominator * secondFraction.numerator;
        return new Fraction(rNumerator, rDenominator);
    }

    @Override
    public String toString() {
        return (numerator + "/" + denominator);
    }
}