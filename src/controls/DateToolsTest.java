
package controls;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DateToolsTest {
    
    /**
     * @subcontract more than 31 days {
     *   @requires day >= 1 && day <=31 && month >= 1 && month <= 12
     *             ;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void moreThan31DaysTest(){
        //arrange
        int day = 32;
        int month = 11;
        int year = 2021;
        //act
        boolean result = DateTools.validateDate(day, month, year);
        //assert
        assertEquals(false, result);
    }
    
    /**
     * @subcontract more than 12 months {
     *   @requires day >= 1 && day <=31 && month == 13
     *             ;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void moreThan12MonthsTest(){
        //arrange
        int day = 30;
        int month = 13;
        int year = 2021;
        //act
        boolean result = DateTools.validateDate(day, month, year);
        //assert
        assertEquals(false, result);
    }
    
    /**
     * @subcontract more than 30 days in even month {
     *   @requires day == 31 && month >= 1 && month <= 12
     *             ;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void moreThan30DaysInEvenMonthsTest(){
        //arrange
        int day = 31;
        int month = 4;
        int year = 2021;
        //act
        boolean result = DateTools.validateDate(day, month, year);
        //assert
        assertEquals(false, result);
    }
    
    /**
     * @subcontract more than 31 days in odd month {
     *   @requires day == 32 && month >= 1 && month <= 12
     *             ;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void moreThan31DaysInOddMonthsTest(){
        //arrange
        int day = 32;
        int month = 5;
        int year = 2021;
        //act
        boolean result = DateTools.validateDate(day, month, year);
        //assert
        assertEquals(false, result);
    }
    
    /**
     * @subcontract more than 29 days in February {
     *   @requires day == 30 && month == 2
     *             ;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void moreThan29DaysInFebruaryTest(){
        //arrange
        int day = 30;
        int month = 2;
        int year = 2021;
        //act
        boolean result = DateTools.validateDate(day, month, year);
        //assert
        assertEquals(false, result);
    }
    
    /**
     * @subcontract valid date {
     *   @requires day >= 1 && day <=31 && month >= 1 || month <= 12
     *             ;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void validDateTest(){
        //arrange
        int day = 31;
        int month = 10;
        int year = 2021;
        //act
        boolean result = DateTools.validateDate(day, month, year);
        //assert
        assertEquals(false, result);
    }
    
    /**
     * @subcontract more than 31 days {
     *   @requires day >= 1 && day <=31 && month >= 1 || month <= 12
     *             ;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void lessThan1DayTest(){
        //arrange
        int day = 0;
        int month = 1;
        int year = 2021;
        //act
        boolean result = DateTools.validateDate(day, month, year);
        
    }
    
}
