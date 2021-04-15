
package DataLayer;

import java.util.List;
import person.Registration;

public interface DAORegistration {
    public List<Registration>findRegistration();
    public boolean deleteRegistration(Registration registration);
    public boolean addRegistration(Registration registration);
}
