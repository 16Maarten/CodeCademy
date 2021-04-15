
package controls;

public class Grade {
    
    public static void main(String[] args) {

    }

    public static boolean FormatGrade(int grade) {
         if (grade >= 1 && grade <= 10) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid Grade");
        }
    }
}
