package Presentation.OverviewsUI;

import Application_Logic.CourseManager;
import Application_Logic.PercentageWatchedManager;
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
import person.PercentageWatched;
import person.Registration;
import products.Course;
import products.Webcast;
import products.Module;

public class NumberOfStudentsPassUI {

    PercentageWatchedManager percentageWatchedManager;
    private RegistrationManager registrationManager;
    private CourseManager courseManager;
    private List<Registration> registrations;
    private List<Course> courses;
    private List<Module> modules;
    private List<Webcast> webcasts;

    public NumberOfStudentsPassUI(CourseManager courseManager, RegistrationManager registrationManager, PercentageWatchedManager percentageWatchedManager) {
        this.courseManager = courseManager;
        this.registrationManager = registrationManager;
        this.percentageWatchedManager = percentageWatchedManager;
        this.registrations = registrationManager.getRegistrations();
    }

    public Parent getView() {
        VBox layout = new VBox();
        courses = courseManager.getCourses();
        ArrayList<String> courseNames = new ArrayList();
        for (int i = 0; i < courses.size(); i++) {
            courseNames.add(courses.get(i).getCursusName());
        }
        Label name = new Label("Select course");
        Label answerNumberOfStudents = new Label();
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(courseNames));
        coursesField.setMaxWidth(Double.MAX_VALUE);
        Button submitButton = new Button("Submit");
        submitButton.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        backButton.setMaxWidth(Double.MAX_VALUE);
        OverviewsUI overviewsUI = new OverviewsUI();
        layout.getChildren().addAll(name, coursesField, submitButton, backButton);

        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(overviewsUI.getView());
        });

        submitButton.setOnAction((event) -> {
            int number = 0;
            List<PercentageWatched> perncentageWatched = this.percentageWatchedManager.getPercentageWatched();
            String courseName = String.valueOf(coursesField.getValue());
            for (int i = 0; i < courses.size(); i++) {
                if (this.courses.get(i).getCursusName().equals(courseName)) {
                    this.modules = this.courses.get(i).getModuleList();
                    this.webcasts = this.courses.get(i).getWebcastList();
                    for (int j = 0; j < registrations.size(); j++) {
                        for (int k = 0; k < perncentageWatched.size(); k++) {
                            if (this.registrations.get(j).getCursusName().equals(courseName) && this.registrations.get(j).getEmail().equals(perncentageWatched.get(k).getEmail())) {
                                if (perncentageWatched.get(k).getPercentage() == 100) {
                                    number++;
                                }
                            }
                        }
                    }
                }
            }
            int answer = number / 4;
            answerNumberOfStudents.setText("Number of students that passed the course: " + answer);
            layout.getChildren().clear();
            layout.getChildren().addAll(name, coursesField, answerNumberOfStudents, submitButton, backButton);
        });

        return layout;

    }

}
