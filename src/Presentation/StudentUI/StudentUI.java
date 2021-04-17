package Presentation.StudentUI;

import Application_Logic.CourseManager;
import Application_Logic.DataManager;
import Application_Logic.StudentManager;
import Presentation.HomeUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentUI {

    private StudentManager studentManager;

    public StudentUI() {
        DataManager manager = new DataManager();
        studentManager = manager.getStudentmanager();
    }

    public Parent getView() {

        BorderPane layout = new BorderPane();
        Button create = new Button("Create Student");
        create.setMaxWidth(Double.MAX_VALUE);
        StudentCreateUI createUI = new StudentCreateUI(studentManager);

        Button read = new Button("Info Student");
        read.setMaxWidth(Double.MAX_VALUE);
        StudentReadUI readUI = new StudentReadUI(studentManager);

        Button update = new Button("Update Student");
        update.setMaxWidth(Double.MAX_VALUE);
        StudentUpdateUI updateUI = new StudentUpdateUI();

        Button delete = new Button("Delete Student");
        delete.setMaxWidth(Double.MAX_VALUE);
        StudentDeleteUI deleteUI = new StudentDeleteUI(studentManager);

        VBox box = new VBox();
        box.getChildren().addAll(create, read, update, delete);
        box.setSpacing(25);
        layout.setCenter(box);

        create.setOnAction((event) -> layout.setCenter(createUI.getView()));
        read.setOnAction((event) -> layout.setCenter(readUI.getView()));
        update.setOnAction((event) -> layout.setCenter(updateUI.getView()));
        delete.setOnAction((event) -> layout.setCenter(deleteUI.getView()));

        return layout;

    }

}
