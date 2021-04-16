package Presentation;

import Presentation.CourseUI.CourseUI;
import Presentation.OverviewsUI.OverviewsUI;
import Presentation.RegistrationUI.RegistrationUI;
import Presentation.StudentUI.StudentUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeUI extends Application{

    @Override
    public void start(Stage windows){

        Label label = new Label("Click on one of the buttons for further actions");
        Button student = new Button("Student");
        StudentUI studentUI = new StudentUI();
        
        Button registration = new Button("Registration");
        RegistrationUI registrationUI = new RegistrationUI();

        Button course = new Button("Course");
        CourseUI courseUI = new CourseUI();

        Button overviews = new Button("Overviews");
        OverviewsUI overviewsUI = new OverviewsUI();

        
        BorderPane layout = new BorderPane();
        VBox box = new VBox();

        Scene scene = new Scene(layout, 300, 300);
        box.getChildren().addAll(label, student, registration, course, overviews);
        box.setSpacing(5);
        layout.setTop(box);

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
    

