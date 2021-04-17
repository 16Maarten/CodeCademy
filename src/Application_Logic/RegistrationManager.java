package Application_Logic;

import DataLayer.DAOFactory;
import java.util.Date;
import java.util.List;
import person.Registration;

public class RegistrationManager {

    private List<Registration> registrations;
    private DAOFactory daoFactory;

    public RegistrationManager(DAOFactory daoFactory) {
        this.registrations = daoFactory.createDAORegistration().findRegistration();
        this.daoFactory = daoFactory;
    }

    public boolean deleteRegistration(String courseName,String email, String registrationDate) {
        for (int i = 0; i < this.registrations.size(); i++) {
            System.out.println(this.registrations.get(i).getCursusName());
            if (this.registrations.get(i).getCursusName().equals(courseName) && this.registrations.get(i).getEmail().equals(email) && this.registrations.get(i).getRegistrationDate().equals(registrationDate)) {
                System.out.println(this.registrations.get(i));
                boolean answer = this.daoFactory.removeDAORegistration(this.registrations.get(i));
                this.registrations.remove(this.registrations.get(i));
                return answer;
            }
        }
        return false;
    }

    public boolean addRegistration(String registrationDate, String email, String cursusName) {
        this.registrations.add(new Registration(registrationDate, email, cursusName));
        return this.daoFactory.addDAORegistration(new Registration(registrationDate, email, cursusName));
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

}
