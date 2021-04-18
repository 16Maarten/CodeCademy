package Presentation.OverviewsUI;

import Application_Logic.CourseManager;
import Application_Logic.PercentageWatchedManager;
import Application_Logic.RegistrationManager;
import Presentation.CourseInfoUI.CourseInfoUI;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.PercentageWatched;
import person.Registration;
import products.Course;
import products.Webcast;
import products.Module;

public class CourseProgressReadUI {

    private RegistrationManager registrationManager;
    private CourseManager courseManager;
    private PercentageWatchedManager percentageWatchedManager;
    private List<Registration> registrations;
    private List<Course> courses;
    private List<Module> modules;
    private List<Webcast> webcasts;
    private String email;
    private String course;

    public CourseProgressReadUI(CourseManager courseManager, PercentageWatchedManager percentageWatchedManager, RegistrationManager registrationManager) {
        this.percentageWatchedManager = percentageWatchedManager;
        this.courseManager = courseManager;
        this.registrationManager = registrationManager;
        this.courses = this.courseManager.getCourses();
    }

    public Parent getView() {
        VBox layout = new VBox();
        ArrayList<String> coursesNames = new ArrayList();
        registrations = registrationManager.getRegistrations();
        ArrayList<String> studentsEmails = new ArrayList();
        for (int i = 0; i < registrations.size(); i++) {
            if (!studentsEmails.contains(registrations.get(i).getEmail())) {
                studentsEmails.add(registrations.get(i).getEmail());
            }
        }

        Label name = new Label("Enter Email");
        Label name2 = new Label("Select Course");
        Label message = new Label("Wrong Email");
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(coursesNames));
        TextField emailInput = new TextField();
        coursesField.setMaxWidth(Double.MAX_VALUE);
        Button submitButton = new Button("Submit");
        submitButton.setMaxWidth(Double.MAX_VALUE);

        Button watchedButton = new Button("Watched");
        watchedButton.setMaxWidth(Double.MAX_VALUE);

        Button submitButton2 = new Button("Submit");
        submitButton2.setMaxWidth(Double.MAX_VALUE);
        Button submitButton3 = new Button("Submit");
        submitButton3.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        OverviewsUI overviewsUI = new OverviewsUI();
        backButton.setMaxWidth(Double.MAX_VALUE);
        Button infoButton = new Button("Info course");
        infoButton.setMaxWidth(Double.MAX_VALUE);

        Label contentAnswer = new Label();

        layout.getChildren().addAll(name, emailInput, submitButton, backButton);
        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(overviewsUI.getView());
        });

        submitButton.setOnAction((event) -> {
            this.email = emailInput.getText();
            for (int i = 0; i < registrations.size(); i++) {
                if (registrations.get(i).getEmail().equals(this.email)) {
                    if (!coursesNames.contains(registrations.get(i).getEmail())) {
                        coursesNames.add(registrations.get(i).getCursusName());
                    }
                    coursesField.setItems(FXCollections.observableArrayList(coursesNames));
                    name.setText("Email: " + this.email);
                    layout.getChildren().clear();
                    layout.getChildren().addAll(name, name2, coursesField, submitButton2, backButton);
                }

            }
            if (!name.getText().equals("Email: " + this.email)) {
                layout.getChildren().clear();
                layout.getChildren().addAll(name, emailInput, message, submitButton, backButton);
            }

        });

        submitButton2.setOnAction((event) -> {
            this.course = String.valueOf(coursesField.getValue());
            String answer = "Content";
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCursusName().equals(this.course)) {
                    this.modules = courses.get(i).getModuleList();
                    this.webcasts = courses.get(i).getWebcastList();
                }

            }
            List<PercentageWatched> PercentageWatched;
            List<PercentageWatched> PercentageWatchedGood = new ArrayList();
            for (int j = 0; j < this.registrations.size(); j++) {
                if (this.registrations.get(j).getEmail().equals(this.email) && this.registrations.get(j).getCursusName().equals(this.course)) {
                    PercentageWatched = this.registrations.get(j).getPercentageWatched();
                    for (int i = 0; i < PercentageWatched.size(); i++) {
                        if(!PercentageWatchedGood.contains(PercentageWatched.get(i))){
                            PercentageWatchedGood.add(PercentageWatched.get(i));
                        }
                    }
                    System.out.println(PercentageWatchedGood.size());
                    for (int k = 0; k < PercentageWatchedGood.size(); k++) {
                        for (int l = 0; l < modules.size(); l++) {
                            if (PercentageWatchedGood.get(k).getContentItemId() == this.modules.get(l).getId()) {
                                answer = answer + "\n" + modules.get(l).getTitle() + ": " + PercentageWatched.get(k).getPercentage() + "%";
                            }
                            if (PercentageWatchedGood.get(k).getContentItemId() == this.webcasts.get(l).getId()) {
                                answer = answer + "\n" + webcasts.get(l).getTitle() + ": " + PercentageWatched.get(k).getPercentage() + "%";
                            }
                        }
                    }

                }
            }
            name2.setText("Course: " + this.course);
            contentAnswer.setText(answer);
            layout.getChildren().clear();
            layout.getChildren().addAll(name, name2, contentAnswer, backButton);

        });

        return layout;

    }

}
