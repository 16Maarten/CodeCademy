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

public class AverageProgressUI{

   
    public Parent getView(){
        GridPane layout = new GridPane();
        
        Label name = new Label("Selected course:");
        ComboBox comboBox = new ComboBox();
        Button courseButton = new Button("Get progress");
        Button backButton = new Button("Back");
        
        layout.add(name, 0, 0);
        layout.add(comboBox, 0, 1);
        layout.add(courseButton, 0, 2);
        layout.add(backButton, 0, 3);

        return layout;
        
    }
    
}
