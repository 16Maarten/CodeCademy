
import Application_Logic.CourseManager;
import DataLayer.DAOFactory;
import DataLayer.SQLDAOFactory;
import java.util.List;
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
        CourseManager manager = new CourseManager(factory);
        List<Course> courses = manager.getCourses();
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i).getCursusName());        
            if (courses.get(i).getWebcastList() != null) {
                System.out.println(courses.get(i).getWebcastList());
            }
            
            if (courses.get(i).getModuleList() != null) {
                System.out.println(courses.get(i).getModuleList());
            }
        }
    }
}
