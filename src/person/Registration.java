
package person;

import java.util.Date;


public class Registration {
    private String registrationDate;
    private String email;
    private String cursusName;

    public Registration(String registrationDate, String email, String cursusName) {
        this.registrationDate = registrationDate;
        this.email = email;
        this.cursusName = cursusName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public String getCursusName() {
        return cursusName;
    }
    

    
    
}
