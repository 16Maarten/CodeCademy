package Presentation;

import Application_Logic.CourseManager;
import Application_Logic.RegistrationManager;
import Application_Logic.StudentManager;
import Presentation.CourseUI.CourseUI;
import Presentation.OverviewsUI.OverviewsUI;
import Presentation.RegistrationUI.RegistrationUI;
import Presentation.StudentUI.StudentUI;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeUI extends Application {

    @Override
    public void start(Stage windows) {

        Label void1 = new Label("    ");
        Label void2 = new Label("     ");
        Label void3 = new Label("     ");
        Label void4 = new Label("    ");
        HBox hbox = new HBox(void1, void2);
        HBox hbox2 = new HBox(void3, void4);
        hbox.setSpacing(300);
        hbox2.setSpacing(300);
        Button student = new Button("Student");
        StudentUI studentUI = new StudentUI();

        Button registration = new Button("Registration");
        RegistrationUI registrationUI = new RegistrationUI();

        Button course = new Button("Course");
        CourseUI courseUI = new CourseUI();

        Button overviews = new Button("Overviews");
        OverviewsUI overviewsUI = new OverviewsUI();

        BorderPane layout = new BorderPane();
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 1000, 550);
        box.getChildren().addAll(student, registration, course, overviews);
        box.setSpacing(25);
        box.setPrefHeight(50);
        layout.setTop(box);
        layout.setLeft(hbox);
        layout.setRight(hbox2);
        student.setOnAction((event) -> layout.setCenter(studentUI.getView()));
        registration.setOnAction((event) -> layout.setCenter(registrationUI.getView()));
        course.setOnAction((event) -> layout.setCenter(courseUI.getView()));
        overviews.setOnAction((event) -> layout.setCenter(overviewsUI.getView()));

        windows.setTitle("Codecademy");

        windows.setScene(scene);
        windows.show();
    }

    public static void main(String[] args) {
        launch(HomeUI.class);
    }

}
