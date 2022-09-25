
import java.util.Scanner;
public class PolyCalcTest
{
  public static void main (String [] args)
  {
    PolyCalc solver = new PolyCalc();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the polynomial to be put to a power(In the form Ax^B+C)");
    String polynomial = sc.nextLine();
    System.out.println("Enter the power");
    int exponent = sc.nextInt();
    Polynomial poly = new Polynomial(polynomial, exponent);
    System.out.println("Expanded binomial:\t" + solver.expand(poly));
    //System.out.println(poly.getFactor());
    //System.out.println(poly.getInExp());
    //System.out.println(poly.getAdd());
    //System.out.println(poly.getOutExp());
    sc.close();
  }
}