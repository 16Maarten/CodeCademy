
import Application_Logic.CourseManager;
import Application_Logic.RegistrationManager;
import Application_Logic.StudentManager;
import DataLayer.DAOFactory;
import DataLayer.SQLDAOFactory;
import Presentation.HomeUI;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import products.Course;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author acer
 */
public class Main {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://LAPTOP-Q21ELVRV;databaseName=ProgRDB;integratedSecurity=true";
        DAOFactory factory = new SQLDAOFactory(connectionUrl);
        CourseManager courseManager = new CourseManager(factory);
        StudentManager studentmanager = new StudentManager(factory);
        RegistrationManager registrationManager = new RegistrationManager(factory);
    }
}

