package Presentation.CourseUI;

import Application_Logic.CourseManager;
import Application_Logic.DataManager;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CourseCreateUI {

    public Parent getView() {
        GridPane layout = new GridPane();

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

        Label space = new Label(" ");

        Button addButton = new Button("Add");
        Button backButton = new Button("Back");
        CourseUI courseUI = new CourseUI();
        Label message = new Label(" ");

        HBox box = new HBox(addButton, backButton);
        box.setSpacing(61);

        layout.add(courseName, 0, 0);
        layout.add(courseNameInput, 0, 1);
        layout.add(subject, 0, 2);
        layout.add(subjectInput, 0, 3);
        layout.add(introText, 0, 4);
        layout.add(introTextInput, 0, 5);
        layout.add(difficulty, 0, 6);
        layout.add(spinner, 0, 7);
        layout.add(space, 0, 8);
        layout.add(box, 0, 9);
        layout.add(message, 0, 10);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.add(courseUI.getView(), 0, 0);
        });

        addButton.setOnAction((event) -> {
            DataManager manager = new DataManager();
            CourseManager courseManager = manager.getCourseManager();
            String nameCourse = courseNameInput.getText();
            String subjectCourse = subjectInput.getText();
            String introTextCourse = introTextInput.getText();
            int difficultyCourse = spinner.getValue();
            boolean answer = courseManager.addCourse(nameCourse, subjectCourse, introTextCourse, difficultyCourse);
            if(answer){
            message.setText("Added course: "+ nameCourse);
            } else {
            message.setText("Something went wrong try again");
            }
        });

        return layout;

    }

}
