
public class Polynomial
{
  private int factor = 0;
  private int addition;
  private int outExp;
  private double inExp;
  private String expression;
  private int xIndex;
  private int endSign;
  public Polynomial(String poly, int exp)
  {
    expression = poly.trim();
    findXIndex(expression);
    findFactor(expression);
    findInExp(expression);
    findAdd(expression);
    outExp = exp;
  }
  private void findXIndex(String poly)
  {
    for (int index = 0; index< poly.length(); index++)
    {
      if (poly.charAt(index) == 'x' || (poly.charAt(index) == 'X'))
        xIndex = index;
    }
  }
  private void findFactor(String poly)
  {
    int sign = 1;
    String tempFactor = poly.substring(0, xIndex);
    if (tempFactor.equals(""))
      factor = 1;
    else if (tempFactor.equals("-"))
      factor = -1;
    else
    {
      int currentTimes = 1;
      if (tempFactor.charAt(0) == '-')
      {
        sign = -1;
        tempFactor = tempFactor.substring(1);
      }
      else 
        sign = 1;
      for(int index = tempFactor.length() - 1 ; index >= 0; index--)
      {
        factor += ((int)tempFactor.charAt(index) - '0') * currentTimes;
        currentTimes = currentTimes * 10; 
      }
      factor = factor * sign;
    }
  }
  private void findInExp(String poly)
  {
    String tempExp;
    int endIndex = 0;
    if (poly.length() == 1 || poly.charAt(xIndex + 1) != '^')
    {
      inExp = 1;
      expression = poly.substring(xIndex + 1);
    }
    else 
    {
      double currentTimes = 1;
      int sign = 1;
      if (poly.charAt(xIndex + 2) == '-')
      {
        sign = -1;
        tempExp = expression.substring(xIndex+3);
      }
      else
        tempExp = expression.substring(xIndex + 2);
      for (endIndex = 0; tempExp.charAt(endIndex) != '-' && tempExp.charAt(endIndex) != '+' && endIndex < tempExp.length(); endIndex++)
      {
        inExp += ((int)tempExp.charAt(endIndex) - '0') * currentTimes;
        currentTimes = currentTimes/10;
      }
      expression = tempExp.substring(endIndex);
      inExp = inExp/(currentTimes*10) * sign;
    }
  }
    private void findAdd(String poly)
    {
      int currentTimes = 1;
      endSign = 1;
      String tempAdd;
      if (poly.length() == 0)
        addition = 0;
      else 
      {
        if (poly.charAt(0) == '-')
          endSign = -1;
        tempAdd = poly.substring(1);
        for(int index = tempAdd.length() - 1 ; index >= 0; index--)
        {
          addition += ((int)tempAdd.charAt(index) - '0') * currentTimes;
          currentTimes = currentTimes * 10; 
        }
      }
      addition = addition * endSign;
    }
    public int getSign()
    {
      return endSign;
    }
    public int getFactor()
    {
      return factor;
    }
    public int getAdd()
    {
      return addition;
    }
    public int getInExp()
    {
      return (int) inExp;
    }
    public int getOutExp()
    {
      return outExp;
    }
}