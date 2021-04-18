
package DataLayer;

import person.*;
import products.Course;

public interface DAOFactory {
    public DAOStudent createDAOStudent();
    public boolean removeDAOStudent(Student student);
    public boolean addDAOStudent(Student student);
    public DAOCourse createDAOCourse();
    public boolean removeDAOCourse(Course course);
    public boolean addDAOCourse(Course course);
    public DAORegistration createDAORegistration();
    public boolean removeDAORegistration(Registration registration);
    public boolean addDAORegistration(Registration registration);
    public DAOWebcast createDAOWebcast();
    public DAOModule createDAOModule();
    public DAOPercentageWatched createDAOPercentageWatched();
    public boolean updatePercentageWatched(PercentageWatched percentageWatched);
    public boolean addPercentageWatched(PercentageWatched percentageWatched);
    public boolean removePercentageWatched(PercentageWatched percentageWatched);
}
