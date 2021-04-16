package Application_Logic;

import DataLayer.DAOFactory;
import java.util.ArrayList;
import java.util.List;
import products.Course;
import products.Webcast;
import products.Module;

public class CourseManager {

    private List<Course> courses;
    private DAOFactory daoFactory;

    public CourseManager(DAOFactory daoFactory) {
        this.courses = daoFactory.createDAOCourse().findCourse();
        this.daoFactory = daoFactory;
        addModulesAndWebcasts(this.courses);
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

    public List<Course> getCourses() {
        return courses;
    }

    private void addModulesAndWebcasts(List<Course> courses) {
        ModuleManager moduleManager = new ModuleManager(this.daoFactory);
        WebcastManager webcastManager = new WebcastManager(this.daoFactory);
        List<Module> modules = moduleManager.getModules();
        List<Webcast> webcasts = webcastManager.getWebcasts();
        for (int i = 0; i < courses.size(); i++) {
            List<Module> modulesCourse = new ArrayList<>();
            List<Webcast> webcastsCourse = new ArrayList<>();
            for (int j = 0; j < modules.size(); j++) {
                if (courses.get(i).getCursusName().equals(modules.get(j).getCursusName())) {
                    modulesCourse.add(modules.get(j));
                }
            }
            courses.get(i).setModuleList(modulesCourse);
            for (int j = 0; j < webcasts.size(); j++) {
                if (courses.get(i).getCursusName().equals(webcasts.get(j).getCursusName())) {
                    webcastsCourse.add(webcasts.get(j));
                }
            }
            courses.get(i).setWebcastList(webcastsCourse);
        }
    }

}
