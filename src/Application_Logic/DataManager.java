package Application_Logic;

import DataLayer.DAOFactory;
import DataLayer.SQLDAOFactory;

public class DataManager {

    private CourseManager courseManager;
    private StudentManager studentmanager;
    private RegistrationManager registrationManager;

    public DataManager() {
        String connectionUrl = "jdbc:sqlserver://LAPTOP-Q21ELVRV;databaseName=ProgRDB;integratedSecurity=true";
        DAOFactory factory = new SQLDAOFactory(connectionUrl);
        courseManager = new CourseManager(factory);
        studentmanager = new StudentManager(factory);
        registrationManager = new RegistrationManager(factory);
    }

    public CourseManager getCourseManager() {
        return courseManager;
    }

    public StudentManager getStudentmanager() {
        return studentmanager;
    }

    public RegistrationManager getRegistrationManager() {
        return registrationManager;
    }
    
    
}
