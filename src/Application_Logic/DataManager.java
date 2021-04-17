package Application_Logic;

import DataLayer.DAOFactory;
import DataLayer.SQLDAOFactory;

public class DataManager {

    private CourseManager courseManager;
    private StudentManager studentmanager;
    private RegistrationManager registrationManager;
    private DAOFactory factory;

    public DataManager() {
        String connectionUrl = "jdbc:sqlserver://LAPTOP-Q21ELVRV;databaseName=ProgRDB;integratedSecurity=true";
        factory = new SQLDAOFactory(connectionUrl);
    }

    public CourseManager getCourseManager() {
        courseManager = new CourseManager(factory);
        return courseManager;
    }

    public StudentManager getStudentmanager() {
        studentmanager = new StudentManager(factory);
        return studentmanager;
    }

    public RegistrationManager getRegistrationManager() {
        registrationManager = new RegistrationManager(factory);
        return registrationManager;
    }

}
