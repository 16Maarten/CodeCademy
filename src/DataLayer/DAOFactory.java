
package DataLayer;

public interface DAOFactory {
    public DAOStudent createDAOStudent();
    public DAOCourse createDAOCourse();
    public DAORegistration createDAORegistration();
    public DAOWebcast createDAOWebcast();
    public DAOModule createDAOModule();
}
