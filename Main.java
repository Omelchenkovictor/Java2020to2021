import java.util.Scanner;
import java.lang.Math;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        double a, b, c;
        System.out.println("введіть 1 дійсне число");
        a = Double.parseDouble(in.next());
        System.out.println("введіть 2 дійсне число");
        b = Double.parseDouble(in.next());
        c = Math.sqrt( a * b );
        System.out.format("середнє геометричне буде %e", c);

    }
}
