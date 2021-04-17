package Application_Logic;

import DataLayer.DAOFactory;
import java.util.Date;
import java.util.List;
import person.Student;

public class StudentManager {

    private List<Student> students;
    private DAOFactory daoFactory;

    public StudentManager(DAOFactory daoFactory) {
        this.students = daoFactory.createDAOStudent().findStudent();
        this.daoFactory = daoFactory;
    }

    public boolean deleteStudent(String studentEmail) {
        for (int i = 0; i < this.students.size(); i++) {
            System.out.println(this.students.get(i).getEmail());
            if (this.students.get(i).getEmail().equals(studentEmail)) {
                System.out.println(this.students.get(i));
                boolean answer = this.daoFactory.removeDAOStudent(this.students.get(i));
                students.remove(this.students.get(i));
                return answer;
            }
        }
        return false;
    }

    public boolean addStudent(String email, String name, String birthDate, String gender, String address, String residence, String country) {
        this.students.add(new Student(email, name, birthDate, gender, address, residence, country));
        return this.daoFactory.addDAOStudent(new Student(email, name, birthDate, gender, address, residence, country));
    }

    public List<Student> getStudents() {
        return students;
    }

}
