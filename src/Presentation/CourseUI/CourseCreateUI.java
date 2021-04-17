package Presentation.CourseUI;

import Application_Logic.CourseManager;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CourseCreateUI {

    private CourseManager manager;

    public CourseCreateUI(CourseManager manager) {
        this.manager = manager;
    }

    public Parent getView() {
        VBox layout = new VBox();

        Label courseName = new Label("Course name");
        TextField courseNameInput = new TextField();

        Label subject = new Label("Subject");
        TextField subjectInput = new TextField();

        Label introText = new Label("Intro text");
        TextField introTextInput = new TextField();

        Label difficulty = new Label("Difficulty indicator");
        final Spinner<Integer> spinner = new Spinner<Integer>();

        final int initialValue = 1;

        // Value factory.
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, initialValue);

        spinner.setValueFactory(valueFactory);

        Button addButton = new Button("Add");
        addButton.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        backButton.setMaxWidth(Double.MAX_VALUE);
        CourseUI courseUI = new CourseUI();
        Label message = new Label();

        layout.getChildren().addAll(courseName, courseNameInput, subject, subjectInput, introText, introTextInput, difficulty, spinner, addButton, backButton, message);
        layout.setSpacing(5);
        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(courseUI.getView());
        });

        addButton.setOnAction((event) -> {
            String nameCourse = courseNameInput.getText();
            String subjectCourse = subjectInput.getText();
            String introTextCourse = introTextInput.getText();
            int difficultyCourse = spinner.getValue();
            boolean answer = manager.addCourse(nameCourse, subjectCourse, introTextCourse, difficultyCourse);
            if (answer) {
                message.setText("Added course: " + nameCourse);
            } else {
                message.setText("Something went wrong try again");
            }
        });

        return layout;

    }

}
