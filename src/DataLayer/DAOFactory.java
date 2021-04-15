
package DataLayer;

import person.Student;

public interface DAOFactory {
    public DAOStudent createDAOStudent();
    public boolean removeDAOStudent(Student student);
    public DAOCourse createDAOCourse();
    public DAORegistration createDAORegistration();
    public DAOWebcast createDAOWebcast();
    public DAOModule createDAOModule();
}
