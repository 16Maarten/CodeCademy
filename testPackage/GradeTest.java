/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavel
 */
public class GradeTest {
    
       /**
     * @subcontract valid grade {
     *   @requires Integer.valueOf(grade) >= 1 && Integer.valueOf(percentage) <= 10;
     *   @ensures \result = true
     * }
     **/
    @Test
    public void validGradeOneTest(){
        //arrange
        int grade = 1;
        //act
        boolean result = Grade.FormatGrade(grade);
        //assert
        assertEquals(true, result);
    }
    
    @Test
    public void validGradeTenTest(){
        //arrange
        int grade = 10;
        //act
        boolean result = Grade.FormatGrade(grade);
        //assert
        assertEquals(true, result);
    }
    
    @Test
    public void validGradeFiveTest(){
        //arrange
        int grade = 5;
        //act
        boolean result = Grade.FormatGrade(grade);
        //assert
        assertEquals(true, result);
    }
    
    
    
    /**
     * @subcontract invalid grade {
     *   @requires no other valid precondition;
     *   @signals (IllegalArgumentException);
     * }
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void invalidPercentageMinusOneTest(){
        //arrange
        int grade = 0;
        //act
        boolean result = Grade.FormatGrade(grade);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void invalidPercentageOneHundredOneTest(){
        //arrange
        int grade = 11;
        //act
        boolean result = Grade.FormatGrade(grade);
    }
    
}
