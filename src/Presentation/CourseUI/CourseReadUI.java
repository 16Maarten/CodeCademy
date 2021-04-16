package Presentation.CourseUI;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CourseReadUI{

    
    public Parent getView(){
        GridPane layout = new GridPane();

        Label name = new Label("Courses:");
        Button backButton = new Button("Back");
        
        layout.add(name, 0, 0);
        layout.add(backButton, 0, 1);

        return layout;
        
    }
    
}
