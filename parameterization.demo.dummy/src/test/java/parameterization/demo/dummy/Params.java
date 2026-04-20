package parameterization.demo.dummy;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Params {
  
  @Test
  @Parameters({"val1","val2"})
  public void Sum(int v1,int v2)
  {
	  int finalSum=v1+v2;
	  System.out.println("The Sum: "+finalSum);
  }
  
  @Test
  @Parameters({"val1","val2"})
  public void Sum1(int v1,int v2)
  {
	  int finalSum=v1-v2;
	  System.out.println("The Sub: "+finalSum);
  }

}
