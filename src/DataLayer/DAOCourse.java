
package DataLayer;

import java.util.List;
import products.Course;

public interface DAOCourse {
    public List<Course>findCourse();
    public boolean deleteCourse(Course course);
    public boolean addCourse(Course course);
}
