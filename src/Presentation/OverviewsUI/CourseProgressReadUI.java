package Presentation.OverviewsUI;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CourseProgressReadUI{

    
    public Parent getView(){
        GridPane layout = new GridPane();

        Label course = new Label("Selected course:");
        ComboBox courseComboBox = new ComboBox();
        Label student = new Label("Selected student:");
        ComboBox studentComboBox = new ComboBox();

        Button courseButton = new Button("Get progress");
        Button backButton = new Button("Back");

        layout.add(course, 0, 0);
        layout.add(courseComboBox, 0, 1);
        layout.add(student, 0, 2);
        layout.add(studentComboBox, 0, 3);
        layout.add(courseButton, 0, 4);
        layout.add(backButton, 0, 5);
        
        return layout;
        
    }
    
}
