package Presentation.CourseInfoUI;

import Presentation.CourseUI.*;
import Application_Logic.CourseManager;
import Application_Logic.DataManager;
import Application_Logic.RegistrationManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CourseInfoUI {

    private RegistrationManager registrationManager;
    private CourseManager courseManager;

    public CourseInfoUI() {
        DataManager manager = new DataManager();
        registrationManager = manager.getRegistrationManager();
        courseManager = manager.getCourseManager();
    }

    public Parent getView() {
        BorderPane layout = new BorderPane();
        Button watchCourse = new Button("Watch course");
        watchCourse.setMaxWidth(Double.MAX_VALUE);
        CourseWatchUI createWatchUI = new CourseWatchUI(registrationManager,courseManager);


        VBox box = new VBox();
        box.getChildren().addAll(watchCourse);
        box.setSpacing(25);
        layout.setCenter(box);

        watchCourse.setOnAction((event) -> layout.setCenter(createWatchUI.getView()));

        return layout;

    }

}
