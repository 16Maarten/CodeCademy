package Presentation.RegistrationUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrationCreateUI extends Application{

    @Override
    public void start(Stage windows) throws Exception {
        Label registration = new Label("Registration date");
        TextField registrationInput = new TextField();

        Label student = new Label("Student");
        TextField studentInput = new TextField();

        Label course = new Label("Course");
        TextField courseInput = new TextField();

        Button button = new Button("Add");
        Button backButton = new Button("Back");

        VBox box = new VBox();
        
        Scene scene = new Scene(box,200,200);
        box.getChildren().addAll(registration, registrationInput,student, studentInput, course, courseInput, button, backButton);
        box.setSpacing(2);

        windows.setTitle("Registration create");

        windows.setScene(scene);
        windows.show();
        
    }
}