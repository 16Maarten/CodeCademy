package Presentation.CourseUI;

import Application_Logic.CourseManager;
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
import products.Course;

public class CourseReadUI {

    private CourseManager manager;
    private List<Course> courses;
    public CourseReadUI(CourseManager manager) {
        this.manager = manager;
    }

    public Parent getView() {
        VBox layout = new VBox();
        courses = manager.getCourses();
        ArrayList<String> courseNames = new ArrayList();
        for (int i = 0; i < courses.size(); i++) {
            courseNames.add(courses.get(i).getCursusName());
        }

        Label name = new Label("Select course");
        Label courseName = new Label("Course: ");
        Label courseNameOutput = new Label();
        Label subject = new Label("Subject: ");
        Label subjectOutput = new Label();
        Label introtext = new Label("IntroText: ");
        Label introtextOutput = new Label();
        Label difficultyIndicator = new Label("DifficultyIndicator: ");
        Label difficultyIndicatorOutput = new Label();
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(courseNames));
        Button backButton = new Button("Back");
        CourseUI courseUI = new CourseUI();
        backButton.setMaxWidth(Double.MAX_VALUE);
        Button infoButton = new Button("Info course");
        infoButton.setMaxWidth(Double.MAX_VALUE);
        layout.getChildren().addAll(name, coursesField, infoButton, backButton);
//        layout.add(name, 0, 0);
//        layout.add(coursesField, 0, 1);
//        layout.add(courseName, 0, 2);
//        layout.add(courseNameOutput, 0, 3);
//        layout.add(subject, 0, 4);
//        layout.add(subjectOutput, 0, 5);
//        layout.add(introtext, 0, 0);
//        layout.add(introtextOutput, 0, 0);
//        layout.add(difficultyIndicator, 0, 0);
//        layout.add(difficultyIndicatorOutput, 0, 0);
//        layout.add(space, 0, 2);
//        layout.add(infoButton, 0, 4);
//        layout.add(space2, 0, 5);
//        layout.add(backButton, 0, 6);
        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(courseUI.getView());
        });

        infoButton.setOnAction((event) -> {
            for (int i = 0; i < courses.size(); i++) {
                if(courses.get(i).getCursusName().equals(coursesField.getValue())){
                courseNameOutput.setText(courses.get(i).getCursusName());
                subjectOutput.setText(courses.get(i).getSubject());
                introtextOutput.setText(courses.get(i).getIntroText());
                difficultyIndicatorOutput.setText(String.valueOf(courses.get(i).getDifficultyIndicator()));
                }
            }

            layout.getChildren().clear();
            layout.getChildren().addAll(name, coursesField, courseName, courseNameOutput, subject, subjectOutput, introtext, introtextOutput, difficultyIndicator, difficultyIndicatorOutput, infoButton, backButton);
        });

        return layout;

    }

}
