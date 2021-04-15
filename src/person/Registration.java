
package person;

import java.util.Date;


public class Registration {
    private Date registrationDate;
    private String email;
    private String cursusName;

    public Registration(Date registrationDate, String email, String cursusName) {
        this.registrationDate = registrationDate;
        this.email = email;
        this.cursusName = cursusName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public String getCursusName() {
        return cursusName;
    }
    

    
    
}
