package Application_Logic;

import DataLayer.DAOFactory;
import java.util.List;
import products.Course;

public class CourseManager {

    private List<Course> courses;
    private DAOFactory daoFactory;

    public CourseManager(DAOFactory daoFactory) {
        this.courses = daoFactory.createDAOCourse().findCourse();
        this.daoFactory = daoFactory;
    }

    public boolean deleteCourse(String courseName) {
        for (int i = 0; i < this.courses.size(); i++) {
            System.out.println(this.courses.get(i).getCursusName());
            if (this.courses.get(i).getCursusName().equals(courseName)) {
                System.out.println(this.courses.get(i));
                return this.daoFactory.removeDAOCourse(this.courses.get(i));
            }
        }
        return false;
    }

    public boolean addCourse(String cursusName, String subject, String introText, int difficultyIndicator) {
        return this.daoFactory.addDAOCourse(new Course(cursusName, subject, introText, difficultyIndicator));
    }

}
