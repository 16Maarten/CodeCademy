
package controls;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MailToolsTest {
    
      /**
     * @desc Validates if mailAddress is valid. It should be in the form of:
     *       <at least 1 character>@<at least 1 character>.<at least 1 character>
     * 
     * @subcontract no mailbox part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[0].length < 1;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void noMailboxPartTest(){
        //arrange
        String mailAddress = "testgmail.com";
        //act
        boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }
    
    @Test
    public void noMailboxPart2Test(){
        //arrange
        String mailAddress = "r@gmail.com";
        //act
        boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }
    
    /**
     * @subcontract subdomain-tld delimiter {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".").length > 2;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void subdomailTldDelimiterTest(){
        //arrange
        String mailAddress = "test@gmail.c";
        //act
        boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }
    /**
     * @subcontract no subdomain part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".")[0].length < 1;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void noSubdomainPartTest(){
        //arrange
        String mailAddress = "test@.com";
        //act
        boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }
    /**
     * @subcontract no tld part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".")[1].length < 1;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void noTldPartTest(){
        //arrange
        String mailAddress = "test@gmail.r";
        //act
        boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(false, result);
    }
    /**
     * @subcontract valid email {
     *   @requires no other precondition
     *   @ensures \result = true;
     * }
     * 
     */
    @Test
    public void validEmailAddressPartTest(){
        //arrange
        String mailAddress = "test@gmail.com";
        //act
        boolean result = MailTools.validateMailAddress(mailAddress);
        //assert
        assertEquals(true, result);
    }
    
}
