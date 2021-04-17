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

    public boolean deleteRegistration(String courseName,String email, Date registrationDate) {
        for (int i = 0; i < this.registrations.size(); i++) {
            System.out.println(this.registrations.get(i).getCursusName());
            if (this.registrations.get(i).getCursusName().equals(courseName) && this.registrations.get(i).getEmail().equals(email) && this.registrations.get(i).getRegistrationDate().equals(registrationDate)) {
                System.out.println(this.registrations.get(i));
                return this.daoFactory.removeDAORegistration(this.registrations.get(i));
            }
        }
        return false;
    }

    public boolean addRegistration(String registrationDate, String email, String cursusName) {
        return this.daoFactory.addDAORegistration(new Registration(registrationDate, email, cursusName));
    }

}
