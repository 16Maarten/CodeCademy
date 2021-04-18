package TestsSrc;

public class DateTools {
    public boolean validateDate(int day, int month, int year) {
        
        //        if(day == 0 || month == 0 || year == 0){
        //            throw new NullPointerException("Day, month or year Cannot Be 0");
        //        }
                
                
                if (month == 1 && 1 < day && day <= 31
                        || month == 3 && 1 >= day && day <= 31
                        || month == 5 && 1 >= day && day <= 31
                        || month == 7 && 1 >= day && day<= 31
                        || month == 8 && 1 >= day && day<= 31
                        || month == 10 && 1 >= day && day<= 31
                        || month == 12 && 1 >= day && day<= 31) {
                    return true;
                }else if(month == 4 && 1 >= day && day <= 30 ||
                        month == 6 && 1 >= day && day <= 30 ||
                        month == 9 && 1 >= day && day <= 30 ||
                        month == 11 && 1 >= day && day <= 30){
                    return true;
                }else if(month == 2 && 1 >= day && day <= 29
                        && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
                    return true;
                }else if(month == 2 && 1 >= day && day <= 28
                        && year % 4 != 0 && (year % 100 == 0 || year % 400 != 0)){
                    return true;
                }
                return false;
            }
        
}
