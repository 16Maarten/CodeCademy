package TestsSrc;
public class Percentage {
    public  boolean FormatPercentage(int percentage) {
        if (percentage >= 0 && percentage <= 100) {
           return true;
       } else {
           throw new IllegalArgumentException();
       }
   }
}
