package controls;

public class Percentage {

    public static void main(String[] args) {

    }

    public static boolean FormatPercentage(int percentage) {
         if (percentage >= 0 && percentage <= 100) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid Percentage");
        }
    }

}
