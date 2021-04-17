package Presentation.RegistrationUI;

import Application_Logic.RegistrationManager;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrationDeleteUI{
    private RegistrationManager manager;

    public RegistrationDeleteUI(RegistrationManager manager) {
        this.manager = manager;
    }
    
    public Parent getView(){
        GridPane layout = new GridPane();
        
        Label registration = new Label("Registration date");
        TextField registrationInput = new TextField();

        Label student = new Label("Student");
        TextField studentInput = new TextField();

        Label course = new Label("Course");
        TextField courseInput = new TextField();

        Button button = new Button("Add");
        Button backButton = new Button("Back");

        layout.add(registration, 0, 0);
        layout.add(registrationInput, 0, 1);
        layout.add(student, 0, 2);
        layout.add(studentInput, 0, 3);
        layout.add(course, 0, 4);
        layout.add(courseInput, 0, 5);
        layout.add(button, 0, 6);
        layout.add(backButton, 0, 7);

        return layout;
        
    }

}
    

