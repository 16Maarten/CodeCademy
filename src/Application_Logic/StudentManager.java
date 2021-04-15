package Application_Logic;

import DataLayer.DAOFactory;
import java.util.List;
import person.Student;

public class StudentManager {

    private List<Student> students;
    private DAOFactory daoFactory;

    public StudentManager(DAOFactory daoFactory) {
        this.students = daoFactory.createDAOStudent().findStudent();
        this.daoFactory = daoFactory;
    }

    public boolean deleteSudent(String studentEmail) {
        for (int i = 0; i < this.students.size(); i++) {
            System.out.println(this.students.get(i).getEmail());
            if (this.students.get(i).getEmail().equals(studentEmail)) {
                System.out.println(this.students.get(i));
                return this.daoFactory.removeDAOStudent(this.students.get(i));
            }
        }
        return false;
    }

}
