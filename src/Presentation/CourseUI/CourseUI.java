package Presentation.CourseUI;

import Application_Logic.CourseManager;
import Application_Logic.DataManager;
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

public class CourseUI {

    private CourseManager courseManager;

    public CourseUI() {
        DataManager manager = new DataManager();
        courseManager = manager.getCourseManager();
    }

    public Parent getView() {
        BorderPane layout = new BorderPane();
        Button create = new Button("Create course");
        create.setMaxWidth(Double.MAX_VALUE);
        CourseCreateUI createUI = new CourseCreateUI(courseManager);

        Button read = new Button("Info course");
        read.setMaxWidth(Double.MAX_VALUE);
        CourseReadUI readUI = new CourseReadUI(courseManager);

        Button delete = new Button("Delete course");
        delete.setMaxWidth(Double.MAX_VALUE);
        CourseDeleteUI deleteUI = new CourseDeleteUI(courseManager);

        VBox box = new VBox();
        box.getChildren().addAll(create, read, delete);
        box.setSpacing(25);
        layout.setCenter(box);

        create.setOnAction((event) -> layout.setCenter(createUI.getView()));
        read.setOnAction((event) -> layout.setCenter(readUI.getView()));
        delete.setOnAction((event) -> layout.setCenter(deleteUI.getView()));

        return layout;

    }

}
