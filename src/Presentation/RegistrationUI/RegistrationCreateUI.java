package Presentation.RegistrationUI;

import Application_Logic.CourseManager;
import Application_Logic.RegistrationManager;
import Application_Logic.StudentManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.Student;
import products.Course;

public class RegistrationCreateUI {

    private RegistrationManager registrationManager;
    private CourseManager courseManager;
    private StudentManager studentmanager;
    private List<Course> courses;
    private List<Student> students;

    public RegistrationCreateUI(RegistrationManager registrationManager, CourseManager courseManager, StudentManager studentManager) {
        this.registrationManager = registrationManager;
        this.courseManager = courseManager;
        this.studentmanager = studentManager;
    }

    public Parent getView() {
        courses = courseManager.getCourses();
        ArrayList<String> courseNames = new ArrayList();
        for (int i = 0; i < courses.size(); i++) {
            courseNames.add(courses.get(i).getCursusName());
        }

        students = studentmanager.getStudents();
        ArrayList<String> studentNames = new ArrayList();
        for (int i = 0; i < students.size(); i++) {
            studentNames.add(students.get(i).getEmail());
        }

        VBox layout = new VBox();

        Label student = new Label("Student");
        ComboBox studentsField = new ComboBox(FXCollections.observableArrayList(studentNames));
        studentsField.setMaxWidth(Double.MAX_VALUE);

        Label course = new Label("Course");
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(courseNames));
        coursesField.setMaxWidth(Double.MAX_VALUE);

        Button addButton = new Button("Add registration");
        addButton.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        backButton.setMaxWidth(Double.MAX_VALUE);
        RegistrationUI registrtationUI = new RegistrationUI();
        Label message = new Label();

        layout.getChildren().addAll(student, studentsField, course, coursesField, addButton, backButton, message);
        layout.setSpacing(5);
        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(registrtationUI.getView());
        });

        addButton.setOnAction((event) -> {
            String registrationDate = String.valueOf(LocalDate.now());
            String emailStudent = String.valueOf(studentsField.getValue());
            String courseName = String.valueOf(coursesField.getValue());
            boolean answer = this.registrationManager.addRegistration(registrationDate, emailStudent, courseName);
            if (answer) {
                message.setText("Added registration");
            } else {
                message.setText("Something went wrong try again");
            }
        });

        return layout;

    }
}
