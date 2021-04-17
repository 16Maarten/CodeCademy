package Presentation.RegistrationUI;

import Application_Logic.CourseManager;
import Application_Logic.DataManager;
import Application_Logic.RegistrationManager;
import Application_Logic.StudentManager;
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

public class RegistrationUI {

    private RegistrationManager registrationManager;
    private CourseManager courseManager;
    private StudentManager studentManager;
    
    public RegistrationUI() {
        DataManager manager = new DataManager();
        this.registrationManager = manager.getRegistrationManager();
        this.courseManager = manager.getCourseManager();
        this.studentManager = manager.getStudentmanager();
    }

    public Parent getView() {
        BorderPane layout = new BorderPane();
        Button create = new Button("Create Registration");
        create.setMaxWidth(Double.MAX_VALUE);
        RegistrationCreateUI createUI = new RegistrationCreateUI(registrationManager,courseManager,studentManager);

        Button read = new Button("Info Registrations");
        read.setMaxWidth(Double.MAX_VALUE);
        RegistrationReadUI readUI = new RegistrationReadUI(registrationManager,courseManager,studentManager);

        Button update = new Button("Update Registration");
        update.setMaxWidth(Double.MAX_VALUE);
        RegistrationUpdateUI updateUI = new RegistrationUpdateUI();

        Button delete = new Button("Delete Registration");
        delete.setMaxWidth(Double.MAX_VALUE);
        RegistrationDeleteUI deleteUI = new RegistrationDeleteUI(registrationManager,courseManager,studentManager);

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
