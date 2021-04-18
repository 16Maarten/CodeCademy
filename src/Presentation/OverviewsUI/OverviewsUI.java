package Presentation.OverviewsUI;

import Application_Logic.CourseManager;
import Application_Logic.DataManager;
import Application_Logic.RegistrationManager;
import Application_Logic.StudentManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OverviewsUI {

    private RegistrationManager registrationManager;
    private CourseManager courseManager;
    private StudentManager studentManager;

    public OverviewsUI() {
        DataManager manager = new DataManager();
        this.registrationManager = manager.getRegistrationManager();
        this.courseManager = manager.getCourseManager();
        this.studentManager = manager.getStudentmanager();
    }

    public Parent getView() {
        BorderPane layout = new BorderPane();

        Button top3 = new Button("Top 3");
        Top3UI top3UI = new Top3UI();
        top3.setMaxWidth(Double.MAX_VALUE);

        Button average = new Button("Average Progress");
        AverageProgressUI averageUI = new AverageProgressUI();
        average.setMaxWidth(Double.MAX_VALUE);

        Button course = new Button("Course progress");
        CourseProgressReadUI courseUI = new CourseProgressReadUI();
        course.setMaxWidth(Double.MAX_VALUE);

        Button number = new Button("Number students pass");
        NumberOfStudentsPassUI numberUI = new NumberOfStudentsPassUI();
        number.setMaxWidth(Double.MAX_VALUE);


        VBox box = new VBox();
        box.getChildren().addAll(top3, average, course, number);
        box.setSpacing(25);
        layout.setCenter(box);

        top3.setOnAction((event) -> layout.setCenter(top3UI.getView()));
        average.setOnAction((event) -> layout.setCenter(averageUI.getView()));
        course.setOnAction((event) -> layout.setCenter(courseUI.getView()));
        number.setOnAction((event) -> layout.setCenter(numberUI.getView()));

        return layout;

    }
}
