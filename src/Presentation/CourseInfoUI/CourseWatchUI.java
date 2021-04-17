package Presentation.CourseInfoUI;

import Presentation.CourseUI.*;
import Application_Logic.CourseManager;
import Application_Logic.RegistrationManager;
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
import products.Course;

public class CourseWatchUI {

    private RegistrationManager registrationManager;
    private CourseManager courseManager;
    private List<Registration> registrations;
    private String email;
    private String course;

    public CourseWatchUI(RegistrationManager registrationManager, CourseManager courseManager) {
        this.registrationManager = registrationManager;
        this.courseManager = courseManager;
    }

    public Parent getView() {
        VBox layout = new VBox();
        ArrayList<String> coursesNames = new ArrayList();
        ArrayList<String> contentItems = new ArrayList();
        registrations = registrationManager.getRegistrations();
        ArrayList<String> studentsEmails = new ArrayList();
        for (int i = 0; i < registrations.size(); i++) {
            if (!studentsEmails.contains(registrations.get(i).getEmail())) {
                studentsEmails.add(registrations.get(i).getEmail());
            }
        }

        Label name = new Label("Select Email");
        Label name2 = new Label("Select Course");
        Label courseNameOutput = new Label();
        Label subjectOutput = new Label();
        Label introtextOutput = new Label();
        Label difficultyIndicatorOutput = new Label();
        ComboBox studentsField = new ComboBox(FXCollections.observableArrayList(studentsEmails));
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(coursesNames));
        coursesField.setMaxWidth(Double.MAX_VALUE);
        ComboBox contenItemsField = new ComboBox(FXCollections.observableArrayList(contentItems));
        contenItemsField.setMaxWidth(Double.MAX_VALUE);
        Button submitButton = new Button("Submit");
        submitButton.setMaxWidth(Double.MAX_VALUE);
        Button submitButton2 = new Button("Submit");
        submitButton2.setMaxWidth(Double.MAX_VALUE);
        studentsField.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        CourseInfoUI courseInfoUI = new CourseInfoUI();
        backButton.setMaxWidth(Double.MAX_VALUE);
        Button infoButton = new Button("Info course");
        infoButton.setMaxWidth(Double.MAX_VALUE);
        layout.getChildren().addAll(name, studentsField, submitButton, backButton);

        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(courseInfoUI.getView());
        });

        submitButton.setOnAction((event) -> {
            this.email = String.valueOf(studentsField.getValue());
            for (int i = 0; i < registrations.size(); i++) {
                if (registrations.get(i).getEmail().equals(this.email)) {
                    if (!coursesNames.contains(registrations.get(i).getEmail())) {
                        coursesNames.add(registrations.get(i).getCursusName());
                    }
                }
            }
            name.setText("Email: " + this.email);
            layout.getChildren().clear();
            layout.getChildren().addAll(name, name2, coursesField, submitButton2, backButton);
        });
        
        submitButton2.setOnAction((event) -> {
            this.course = String.valueOf(coursesField.getValue());
            for (int i = 0; i < registrations.size(); i++) {
                if (registrations.get(i).getEmail().equals(this.email)) {
                    if (!coursesNames.contains(registrations.get(i).getEmail())) {
                        coursesNames.add(registrations.get(i).getCursusName());
                    }
                }
            }
            name2.setText("Course: " + this.email);
            layout.getChildren().clear();
            layout.getChildren().addAll(name, name2, coursesField, submitButton2, backButton);
        });

        infoButton.setOnAction((event) -> {
//            for (int i = 0; i < courses.size(); i++) {
//                if (courses.get(i).getCursusName().equals(coursesField.getValue())) {
//                    courseNameOutput.setText("Course: " + courses.get(i).getCursusName());
//                    subjectOutput.setText("Subject: " + courses.get(i).getSubject());
//                    introtextOutput.setText("Introtext: " + courses.get(i).getIntroText());
//                    difficultyIndicatorOutput.setText("Difficulty: " + String.valueOf(courses.get(i).getDifficultyIndicator()));
//                }
//            }

            layout.getChildren().clear();
            //layout.getChildren().addAll(name, coursesField, courseNameOutput, subjectOutput, introtextOutput, difficultyIndicatorOutput, infoButton, backButton);
        });

        return layout;

    }

}
