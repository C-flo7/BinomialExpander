
public class PolyCalc
{
  double[] terms;
  public String expand(Polynomial poly)
  {
    terms = new double [(poly.getOutExp() + 1)];
    solve(poly);
    String result = "";
    for (int index = 0; index < terms.length - 1 ; index++)
    {
      if (Math.pow(poly.getSign(), index + 1) == -1)
        result += (int)terms[index] + "x^" + ((poly.getOutExp() - index)*poly.getInExp()) + " "; 
      else
        result += (int)terms[index] + "x^" + ((poly.getOutExp() - index)*poly.getInExp()) + " + ";
    }
    result += (int)terms[terms.length-1]; 
    return result;
  }
  private void solve(Polynomial poly)
  {
    int exp = poly.getOutExp();
    for (int i = 1; i <= exp + 1; i++)
    {
      terms[i-1] = ((factorial(exp))/(factorial(exp - i + 1) * factorial(i - 1)))
                     *Math.pow(poly.getFactor(),(exp-i+1)) * Math.pow(poly.getAdd(),(i-1));
    }
  }
  private int factorial(int n)
  {
    if (n == 0)    
      return 1;    
    else    
      return(n * factorial(n-1));
  }
}