package Presentation.RegistrationUI;

import Application_Logic.CourseManager;
import Application_Logic.RegistrationManager;
import Application_Logic.StudentManager;
import Presentation.StudentUI.StudentUI;
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
import person.Registration;
import person.Student;
import products.Course;

public class RegistrationDeleteUI {

    private RegistrationManager registrationManager;
    private CourseManager courseManager;
    private StudentManager studentmanager;
    private List<Course> courses;
    private List<Student> students;
    private List<Registration> registrations;

    public RegistrationDeleteUI(RegistrationManager registrationManager, CourseManager courseManager, StudentManager studentManager) {
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

        this.registrations = this.registrationManager.getRegistrations();
        ArrayList<String> registrationDates = new ArrayList();
        for (int i = 0; i < registrations.size(); i++) {
            registrationDates.add(registrations.get(i).getRegistrationDate());
        }

        VBox layout = new VBox();

        Label emailTitle = new Label("Select student email");
        ComboBox studentsField = new ComboBox(FXCollections.observableArrayList(studentNames));
        studentsField.setMaxWidth(Double.MAX_VALUE);
        Label courseTitle = new Label("Select student email");
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(courseNames));
        coursesField.setMaxWidth(Double.MAX_VALUE);
        Label message = new Label();
        Button deleteButton = new Button("Delete Registration");
        deleteButton.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        backButton.setMaxWidth(Double.MAX_VALUE);
        RegistrationUI registrationUI = new RegistrationUI();
        layout.getChildren().addAll(emailTitle, studentsField, courseTitle, coursesField, deleteButton, backButton, message);
        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(registrationUI.getView());
        });

        deleteButton.setOnAction((event) -> {
            String emailStudent = String.valueOf(studentsField.getValue());
            String courseName = String.valueOf(coursesField.getValue());
            String regsitrationDate = "";
            for (int i = 0; i < registrations.size(); i++) {
                if (registrations.get(i).getEmail().equals(studentsField.getValue()) && registrations.get(i).getCursusName().equals(coursesField.getValue())) {
                    regsitrationDate = this.registrations.get(i).getRegistrationDate();
                }
            }
            boolean answer = registrationManager.deleteRegistration(courseName, emailStudent, regsitrationDate);
            if (answer) {
                message.setText("Registration deleted");
            } else {
                message.setText("Something went wrong try again");
            }
        });

        return layout;

    }

}
