
package controls;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PostalCodeTest {
    
    
    
    
    
   

    /**
     * @desc Formats the input postal code to a uniform output in the form
     * nnnn<space>MM, where nnnn is numeric and > 999 and MM are 2 capital letters.
     * Spaces before and after the input string are trimmed.
     * 
     * @subcontract null postalCode {
     *   @requires postalCode == null;
     *   @signals (NullPointerException) postalCode == null;
     * }
     **/
    @Test(expected = NullPointerException.class)
    public void nullPostalCodeTest(){
        //arrange
        String postalCode = null;
        //act
        String result = PostalCode.FormatPostalCode(postalCode);
    }
    /**
     * @subcontract valid postalCode {
     *   @requires Integer.valueOf(postalCode.trim().substring(0, 4)) > 999 &&
     *             Integer.valueOf(postalCode.trim().substring(0, 4)) <= 9999 &&
     *             postalCode.trim().substring(4).trim().length == 2 &&
     *             'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z' &&
     *             'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z';
     *   @ensures \result = postalCode.trim().substring(0, 4) + " " +
     *                  postalCode.trim().substring(4).trim().toUpperCase()
     * }
     **/
    @Test
    public void validPostalCode9999AZTest(){
        //arrange
        String postalCode = "9999AZ";
        //act
        String result = PostalCode.FormatPostalCode(postalCode);
        //assert
        assertEquals("9999 AZ", result);
    }
    
    @Test
    public void validPostalCode1000ZATest(){
        //arrange
        String postalCode = "1000ZA";
        //act
        String result = PostalCode.FormatPostalCode(postalCode);
        //assert
        assertEquals("1000 ZA", result);
    }
    
    
    
    /**
     * @subcontract invalid postalCode {
     *   @requires no other valid precondition;
     *   @signals (IllegalArgumentException);
     * }
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void invalidPostalCode999AZTest(){
        //arrange
        String postalCode = "999AZ";
        //act
        String result = PostalCode.FormatPostalCode(postalCode);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void invalidPostalCode10000AZTest(){
        //arrange
        String postalCode = "10000AZ";
        //act
        String result = PostalCode.FormatPostalCode(postalCode);
    }
    @Test(expected = IllegalArgumentException.class)
    public void invalidPostalCode1000ATest(){
        //arrange
        String postalCode = "1000A";
        //act
        String result = PostalCode.FormatPostalCode(postalCode);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void invalidPostalCode1000AZATest(){
        //arrange
        String postalCode = "1000AZA";
        //act
        String result = PostalCode.FormatPostalCode(postalCode);
    }
    
    

    
    
}
