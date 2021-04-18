package person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Registration {

    private String registrationDate;
    private String email;
    private String cursusName;
    private List<PercentageWatched> percentageWatched;

    public Registration(String registrationDate, String email, String cursusName) {
        this.registrationDate = registrationDate;
        this.email = email;
        this.cursusName = cursusName;
        this.percentageWatched = new ArrayList();
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

    public List<PercentageWatched> getPercentageWatched() {
        return percentageWatched;
    }

    public void setPercentageWatched(List<PercentageWatched> percentageWatched) {
        this.percentageWatched = percentageWatched;
    }
    
    

}
