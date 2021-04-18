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
import products.Webcast;
import products.Module;

public class CourseWatchUI {

    private RegistrationManager registrationManager;
    private CourseManager courseManager;
    private List<Registration> registrations;
    private List<Course> courses;
    private List<Module> modules;
    private List<Webcast> webcasts;
    private String email;
    private String course;
    private String lesson;

    public CourseWatchUI(RegistrationManager registrationManager, CourseManager courseManager) {
        this.registrationManager = registrationManager;
        this.courseManager = courseManager;
        courses = this.courseManager.getCourses();
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
        Label name3 = new Label("Select Lesson");

        ComboBox studentsField = new ComboBox(FXCollections.observableArrayList(studentsEmails));
        ComboBox contenItemsField = new ComboBox(FXCollections.observableArrayList(contentItems));
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(coursesNames));
        coursesField.setMaxWidth(Double.MAX_VALUE);
        contenItemsField.setMaxWidth(Double.MAX_VALUE);
        Button submitButton = new Button("Submit");
        submitButton.setMaxWidth(Double.MAX_VALUE);
        Button watchedButton = new Button("Watched");
        watchedButton.setMaxWidth(Double.MAX_VALUE);
        Button submitButton2 = new Button("Submit");
        submitButton2.setMaxWidth(Double.MAX_VALUE);
        Button submitButton3 = new Button("Submit");
        submitButton3.setMaxWidth(Double.MAX_VALUE);
        studentsField.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        CourseInfoUI courseInfoUI = new CourseInfoUI();
        backButton.setMaxWidth(Double.MAX_VALUE);
        Button infoButton = new Button("Info course");
        infoButton.setMaxWidth(Double.MAX_VALUE);

        Label contentTitle = new Label();
        Label contentPublicationDate = new Label();
        Label contentDescription = new Label();
        Label contentInfo1 = new Label();
        Label contentInfo2 = new Label();
        Label contentInfo3 = new Label();
        Label contentInfo4 = new Label();

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
                coursesField.setItems(FXCollections.observableArrayList(coursesNames));
            }

            name.setText("Email: " + this.email);
            layout.getChildren().clear();
            layout.getChildren().addAll(name, name2, coursesField, submitButton2, backButton);
        });

        submitButton2.setOnAction((event) -> {
            this.course = String.valueOf(coursesField.getValue());
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCursusName().equals(this.course)) {
                    this.modules = courses.get(i).getModuleList();
                    this.webcasts = courses.get(i).getWebcastList();
                    for (int j = 0; j < this.modules.size(); j++) {
                        if (!contentItems.contains(this.modules.get(j).getId() + " " + this.modules.get(j).getTitle())) {
                            contentItems.add(this.modules.get(j).getId() + " " + this.modules.get(j).getTitle());
                        }
                    }
                    for (int j = 0; j < this.webcasts.size(); j++) {
                        if (!contentItems.contains(this.webcasts.get(j).getId() + " " + this.webcasts.get(j).getTitle())) {
                            contentItems.add(this.webcasts.get(j).getId() + " " + this.webcasts.get(j).getTitle());
                        }
                    }
                }
            }
            contenItemsField.setItems(FXCollections.observableArrayList(contentItems));
            name2.setText("Course: " + this.course);
            name3.setText("Select lesson: ");
            layout.getChildren().clear();
            layout.getChildren().addAll(name, name2, name3, contenItemsField, submitButton3, backButton);
        });

        submitButton3.setOnAction((event) -> {
            this.lesson = String.valueOf(contenItemsField.getValue());
            String[] parts = this.lesson.split(" ");
            int contentId = Integer.valueOf(parts[0]);
            submitButton2.setText("Choose an other lesson");
            name3.setText("Lesson: " + this.lesson);
            for (int i = 0; i < modules.size(); i++) {
                if (this.modules.get(i).getId() == contentId) {
                    contentTitle.setText("Title: " + this.modules.get(i).getTitle());
                    contentPublicationDate.setText("Publication date: " + String.valueOf(this.modules.get(i).getPublicationDate()));
                    contentDescription.setText("Description: " + this.modules.get(i).getDescription());
                    contentInfo1.setText("Version: " + String.valueOf(this.modules.get(i).getVersion()));
                    contentInfo2.setText("Contactperson: " + this.modules.get(i).getContactPersonName());
                    contentInfo3.setText("Contactperson email: " + this.modules.get(i).getContactPersonEmail());
                    layout.getChildren().clear();
                    layout.getChildren().addAll(name, name2, name3, contentTitle, contentInfo1, contentPublicationDate, contentDescription, contentInfo2, contentInfo3, watchedButton, submitButton2, backButton);
                }
            }

            for (int i = 0; i < webcasts.size(); i++) {
                if (this.webcasts.get(i).getId() == contentId) {
                    contentTitle.setText("Title: " + this.webcasts.get(i).getTitle());
                    contentPublicationDate.setText("Publication date: " + String.valueOf(this.webcasts.get(i).getPublicationDate()));
                    contentDescription.setText("Description: " + this.webcasts.get(i).getDescription());
                    contentInfo1.setText("URL: " + String.valueOf(this.webcasts.get(i).getUrl()));
                    contentInfo2.setText("Duration: " + this.webcasts.get(i).getDuration());
                    contentInfo3.setText("Expert Name: " + this.webcasts.get(i).getExpertName());
                    contentInfo4.setText("Organisation: " + this.webcasts.get(i).getExpertOrganisation());
                    layout.getChildren().clear();
                    layout.getChildren().addAll(name, name2, name3, contentTitle, contentPublicationDate, contentDescription, contentInfo1, contentInfo2, contentInfo3, contentInfo4, watchedButton, submitButton2, backButton);
                }
            }

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
