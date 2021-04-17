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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import products.Course;

public class CourseDeleteUI {

    private CourseManager manager;
    private List<Course> courses;

    public CourseDeleteUI(CourseManager manager) {
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
        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(courseNames));
        Label message = new Label();
        Button deleteButton = new Button("Delete course");
        deleteButton.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        backButton.setMaxWidth(Double.MAX_VALUE);
        CourseUI courseUI = new CourseUI();
        layout.getChildren().addAll(name, coursesField, deleteButton, backButton, message);
        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(courseUI.getView());
        });

        deleteButton.setOnAction((event) -> {
            String nameCourse = String.valueOf(coursesField.getValue());
            boolean answer = manager.deleteCourse(nameCourse);
            if (answer) {
                message.setText("Deleted course: " + nameCourse);
            } else {
                message.setText("Something went wrong try again");
            }
        });

        return layout;

    }

}
