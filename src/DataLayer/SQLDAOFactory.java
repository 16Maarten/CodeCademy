
package DataLayer;

import person.Student;

public class SQLDAOFactory implements DAOFactory{
    private String connectionUrl;

    public SQLDAOFactory(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    @Override
    public DAOStudent createDAOStudent() {
        return new SQLDAOStudent(this.connectionUrl);
    }

    @Override
    public DAOCourse createDAOCourse() {
        return new SQLDAOCourse(this.connectionUrl);
    }

    @Override
    public DAORegistration createDAORegistration() {
        return new SQLDAORegistration(this.connectionUrl);
    }

    @Override
    public DAOWebcast createDAOWebcast() {
        return new SQLDAOWebcast(this.connectionUrl);
    }

    @Override
    public DAOModule createDAOModule() {
        return new SQLDAOModule(this.connectionUrl);
    }
    
    @Override
    public boolean removeDAOStudent(Student student) {
         return new SQLDAOStudent(this.connectionUrl).deleteStudent(student);
    }
    
}
