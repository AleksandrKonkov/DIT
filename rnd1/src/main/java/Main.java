import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

public static void main(String[] args) {
        System.out.println("solution of an equation of the form \"ax^2+bx+c=-7\"");
        Scanner scanner = new Scanner(System.in);

try {
        System.out.println( "Enter in number format a, b, c: " );
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();


        scanner.close();

        double discriminant = Math.pow(b, 2) - 4 * a * (c+7);

        System.out.print("The equation has ");
        if (discriminant > 0)
        {
        double root1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a);
        double root2 = (-b - Math.pow(discriminant, 0.5)) / (2 * a);
        System.out.println("two roots " + root1 + " and " + root2);
        }
        else if (discriminant == 0)
        {
        double root1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a);
        System.out.println("one root " + root1);
        }
        else
        System.out.println("no real roots");

} catch (
        InputMismatchException e) {
                System.out.println( "you entered a non-number format" );
        }

}}