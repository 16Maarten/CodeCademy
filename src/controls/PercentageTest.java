
package controls;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PercentageTest {
    
    /**
     * @desc Percentage needs to be a digit between 0 and 100. 
     * 
     * @subcontract null percentage {
     *   @requires percentage = null;
     *   @signals (NullPointerException) persentage = null;
     * }
     **/
   // @Test(expected = NullPointerException.class)
    //public void nullPercentageTest(){
        //arrange
      //  String percentage = null;
        //act
        //boolean result = Percentage.FormatPercentage(percentage);
    //}
    /**
     * @subcontract valid percentage {
     *   @requires Integer.valueOf(percentage) >= 0 && Integer.valueOf(percentage) <= 100;
     *   @ensures \result = true
     * }
     **/
    @Test
    public void validPercentageZeroTest(){
        //arrange
        int percentage = 0;
        //act
        boolean result = Percentage.FormatPercentage(percentage);
        //assert
        assertEquals(true, result);
    }
    
    @Test
    public void validPercentageOneHundredTest(){
        //arrange
        int percentage = 100;
        //act
        boolean result = Percentage.FormatPercentage(percentage);
        //assert
        assertEquals(true, result);
    }
    
    @Test
    public void validPercentageFiftyTest(){
        //arrange
        int percentage = 50;
        //act
        boolean result = Percentage.FormatPercentage(percentage);
        //assert
        assertEquals(true, result);
    }
    
    
    
    /**
     * @subcontract invalid percentage {
     *   @requires no other valid precondition;
     *   @signals (IllegalArgumentException);
     * }
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void invalidPercentageMinusOneTest(){
        //arrange
        int percentage = -1;
        //act
        boolean result = Percentage.FormatPercentage(percentage);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void invalidPercentageOneHundredOneTest(){
        //arrange
        int percentage = 101;
        //act
        boolean result = Percentage.FormatPercentage(percentage);
    }
    
    
    

   
    
}
