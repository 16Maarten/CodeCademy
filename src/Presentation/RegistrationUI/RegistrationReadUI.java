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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.Registration;
import person.Student;
import products.Course;

public class RegistrationReadUI {

    private RegistrationManager registrationManager;
    private CourseManager courseManager;
    private StudentManager studentmanager;
    private List<Course> courses;
    private List<Student> students;
    private List<Registration> registrations;

    public RegistrationReadUI(RegistrationManager registrationManager, CourseManager courseManager, StudentManager studentManager) {
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

        Label emailtitle = new Label("Select student email");
        Label emailOutput = new Label();
        Label courseTitle = new Label("Select Course");
        Label message = new Label();
        Label courseOutput = new Label();
        Label registrationDateOutput = new Label();
        ComboBox studentsField = new ComboBox(FXCollections.observableArrayList(studentNames));
        studentsField.setMaxWidth(Double.MAX_VALUE);
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(courseNames));
        coursesField.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        RegistrationUI registrationUI = new RegistrationUI();
        backButton.setMaxWidth(Double.MAX_VALUE);
        Button infoButton = new Button("Info Student");
        infoButton.setMaxWidth(Double.MAX_VALUE);
        layout.getChildren().addAll(emailtitle, studentsField, courseTitle, coursesField, infoButton, backButton);

        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(registrationUI.getView());
        });

        infoButton.setOnAction((event) -> {
            for (int i = 0; i < registrations.size(); i++) {
                if (registrations.get(i).getEmail().equals(studentsField.getValue()) && registrations.get(i).getCursusName().equals(coursesField.getValue())) {
                    emailOutput.setText("Email: " + registrations.get(i).getEmail());
                    courseOutput.setText("Course: " + registrations.get(i).getCursusName());
                    registrationDateOutput.setText("Registration Date: " + registrations.get(i).getRegistrationDate());
                    layout.getChildren().clear();
                    layout.getChildren().addAll(emailtitle, studentsField, courseTitle, coursesField, emailOutput, courseOutput, registrationDateOutput, infoButton, backButton);

                } 
            }
        });;

        return layout;

    }

}
