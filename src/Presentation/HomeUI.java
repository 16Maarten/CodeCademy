package Presentation;

import Presentation.StudentUI.StudentUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeUI extends Application{

    @Override
    public void start(Stage windows){

        Label label = new Label("Click on one of the buttons for further actions");
        Button student = new Button("Student");
        StudentUI studentUI = new StudentUI();
        
        Button registration = new Button("Registration");
        Button course = new Button("Course");
        Button overviews = new Button("Overviews");

        

        // BorderPane layout = new BorderPane();
        VBox box = new VBox();

        Scene scene = new Scene(box,200,200);
        box.getChildren().addAll(label, student, registration, course, overviews);
        box.setSpacing(5);

        // student.setOnAction((event) -> box.setCenter(studentUI.getClass()));

        windows.setTitle("Codecademy");

        windows.setScene(scene);
        windows.show();
    }

    public static void main(String[] args) {
        launch(HomeUI.class);
    }

}
    

