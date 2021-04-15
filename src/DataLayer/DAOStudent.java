
package DataLayer;

import java.util.List;
import person.Student;

public interface DAOStudent {
    public List<Student>findStudent();
    public boolean deleteStudent(Student student);
}
