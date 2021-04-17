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
        Label courseNameOutput = new Label();
        Label subjectOutput = new Label();
        Label introtextOutput = new Label();
        Label difficultyIndicatorOutput = new Label();
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(courseNames));
        coursesField.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        CourseUI courseUI = new CourseUI();
        backButton.setMaxWidth(Double.MAX_VALUE);
        Button infoButton = new Button("Info course");
        infoButton.setMaxWidth(Double.MAX_VALUE);
        layout.getChildren().addAll(name, coursesField, infoButton, backButton);

        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(courseUI.getView());
        });

        infoButton.setOnAction((event) -> {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCursusName().equals(coursesField.getValue())) {
                    courseNameOutput.setText("Course: " + courses.get(i).getCursusName());
                    subjectOutput.setText("Subject: " + courses.get(i).getSubject());
                    introtextOutput.setText("Introtext: " + courses.get(i).getIntroText());
                    difficultyIndicatorOutput.setText("Difficulty: " + String.valueOf(courses.get(i).getDifficultyIndicator()));
                }
            }

            layout.getChildren().clear();
            layout.getChildren().addAll(name, coursesField, courseNameOutput, subjectOutput, introtextOutput, difficultyIndicatorOutput, infoButton, backButton);
        });

        return layout;

    }

}
